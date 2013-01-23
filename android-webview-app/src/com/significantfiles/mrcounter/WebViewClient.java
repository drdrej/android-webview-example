package com.significantfiles.mrcounter;

import android.util.Log;

import android.webkit.WebView;
import static com.significantfiles.mrcounter.Constants.*;

public class WebViewClient extends android.webkit.WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
		Log.d(LOG_TAG, "Loading url [= " + url + "]");
		view.loadUrl(url);
		
		return true;
	}
}