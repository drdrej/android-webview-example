package com.significantfiles.mrcounter.js;

import com.significantfiles.mrcounter.Constants;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;

public class WebViewFacade {

	private final WebView webView;

	public WebViewFacade( final WebView view ) {
		this.webView = view;
	}
	
	public static String name() {
		return WebViewFacade.class.getSimpleName();
	}

	public void sendDocumentReady() {
		Log.d( Constants.LOG_TAG, "Activate WebView." );
//		this.webView.setVisibility(View.VISIBLE);
		this.webView.bringToFront();
	}

	public String buildDate() {
		return String.valueOf( System.currentTimeMillis() );
	}
}
