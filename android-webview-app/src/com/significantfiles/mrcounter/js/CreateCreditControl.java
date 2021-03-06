package com.significantfiles.mrcounter.js;

import com.significantfiles.mrcounter.ActivityRequestCode;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.provider.Contacts.People;
import android.webkit.WebView;

public class CreateCreditControl {

	private final WebView webView;
  
	public CreateCreditControl(final WebView webView) {
		this.webView = webView;
	}
	 
	private Handler mHandler = new Handler();

	public void alert() {
		mHandler.post(new Runnable() {
			public void run() {
				webView.loadUrl("javascript:alert( 'Alert works well!' )");
			} 
		});

	}

	public static String name() {
		return CreateCreditControl.class.getSimpleName();
	}

	
	public void callContactsManager() {
		final Uri uri = People.CONTENT_URI;
		final Intent intent = new Intent(Intent.ACTION_PICK, uri);
		
		final Activity activity = (Activity) webView.getContext();
		activity.startActivityForResult(intent, ActivityRequestCode.SELECT_CONTRACT);
	}

	public void exit() {
		final Activity activity = (Activity) webView.getContext();
		activity.finish();
	}
	
}
