package com.significantfiles.mrcounter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Contacts.People;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebSettings.RenderPriority;

import com.significantfiles.android.sqlite.GET;
import com.significantfiles.mrcounter.R;
import com.significantfiles.mrcounter.js.CreateCreditControl;
import com.significantfiles.mrcounter.js.WebViewFacade;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import static com.significantfiles.mrcounter.ActivityRequestCode.*;

/**
 * // createView( "file:///android_asset/html/startProcess.html" ); // loadUrl(
 * "file:///android_asset/html/startProcess.html" );
 * 
 * @author Andreas Siebert
 */
public class StartActivity extends Activity {

	// private static final String START_ACTIVITY =
	// "file:///android_asset/html/test/useJavaItf.html";

	private static final String START_ACTIVITY = "file:///android_asset/html/performance_create_credit.html";

	private WebView webView;

	private CreateCreditControl createCreditControl;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);

			/* 
			 * final Window window = getWindow();
			 * 
			 * window.setFormat(PixelFormat.RGBA_8888);
			 */

			setContentView(R.layout.credits_list);

			if (savedInstanceState != null) {
				reuseView(savedInstanceState);
			} else {
				createView(START_ACTIVITY);
			}
		} catch (Throwable e) {
			// TODO: handle exception
			Log.e("lll", "jjj", e);
			e.printStackTrace();

		}
	}

	private void createView(final String url) {
		this.webView = (WebView) findViewById(R.id.webview);
		this.webView.setAlwaysDrawnWithCacheEnabled(true);
		this.webView.setAnimationCacheEnabled(true);
		this.webView.setFocusableInTouchMode(true);
		this.webView.setDrawingCacheEnabled(true);
		this.webView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
		this.webView.setDrawingCacheEnabled(true);
		this.webView.setKeepScreenOn(true);
		
		this.webView.setWebViewClient(new WebViewClient());

		final WebSettings webSettings = webView.getSettings();
		webSettings.setSavePassword(false);
		webSettings.setSaveFormData(false);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setSupportZoom(false);
		webSettings.setCacheMode( WebSettings.LOAD_NO_CACHE );
		webSettings.setPluginsEnabled( false );
		webSettings.setSupportMultipleWindows(false);
		webSettings.setRenderPriority( RenderPriority.HIGH );
		webSettings.setUseWideViewPort(true);
		
		final WebChromeClient chromeClient = new com.significantfiles.mrcounter.WebChromeClient(
				this);
		webView.setWebChromeClient(chromeClient);

		initJavaScriptInterfaces();

		webView.setAlwaysDrawnWithCacheEnabled(false);

		webView.loadUrl(url);
	}

	private void initJavaScriptInterfaces() {
		this.createCreditControl = new CreateCreditControl(webView);
		webView.addJavascriptInterface(createCreditControl,
				CreateCreditControl.name());
		
		final WebViewFacade webViewFacade = new WebViewFacade(webView);
		webView.addJavascriptInterface(webViewFacade,
				WebViewFacade.name());
	}

	private void reuseView(Bundle savedInstanceState) {
		this.webView = ((WebView) findViewById(R.id.webview));
		// this.webView.restoreState(savedInstanceState);
		this.webView.reload();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		final boolean shouldGoBack = (keyCode == KeyEvent.KEYCODE_BACK)
				&& webView.canGoBack();

		if (shouldGoBack) {
			webView.goBack();
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	protected void onSaveInstanceState(Bundle outState) {
		webView.saveState(outState);
	}

	private Handler mHandler = new Handler();

	private void notifyJavascriptView(final int resultCode, final Intent data) {
		final Uri contact = data.getData();
		final Cursor cursor = managedQuery(contact, null, null, null, null);

		if (!cursor.moveToFirst()) {
			Log.e(Constants.LOG_TAG,
					"No contact selected. Or Contacts-DB is empty.");

			return;
		}

		final String name = GET.string(cursor, People.DISPLAY_NAME);
        final String phone = GET.string(cursor, People.NUMBER_KEY );
		
		mHandler.post(new Runnable() {
			public void run() {
				webView.loadUrl("javascript:contactSelected( '" + name + "', '" + phone + "' )");
			}
		});
	}

	@Override
	public void onActivityResult(int reqCode, int resultCode, Intent data) {
		super.onActivityResult(reqCode, resultCode, data);

		switch (reqCode) {
		case SELECT_CONTRACT:
			notifyJavascriptView(resultCode, data);
			break;
		}
	}

}
