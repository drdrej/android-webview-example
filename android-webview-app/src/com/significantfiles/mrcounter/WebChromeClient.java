package com.significantfiles.mrcounter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.webkit.ConsoleMessage.MessageLevel;

public class WebChromeClient extends android.webkit.WebChromeClient {

	private final Activity ctx;

	public WebChromeClient(final Activity ctx) {
		this.ctx = ctx;
	}

	/**
	 * für alert() -> debug.
	 */
	@Override
	public boolean onJsAlert(final WebView view, final String url,
			final String message, final JsResult result) {
		Log.d(Constants.LOG_TAG, message);

		new AlertDialog.Builder(ctx)
				.setTitle("javaScript dialog")
				.setMessage(message)
				.setPositiveButton(android.R.string.ok,
						new AlertDialog.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int which) {
								result.confirm();
							}
						}).setCancelable(false).create().show();

		return true;
	}

	public void onProgressChanged(WebView view, int progress) {
		ctx.setTitle("Loading...");
		ctx.setProgress(progress * 100);

		if (progress == 100)
			ctx.setTitle("Mr.Counter - V. 1.0 (20.01.2011)");
	}

	public boolean onConsoleMessage(final ConsoleMessage cm) {
		final MessageLevel level = cm.messageLevel();

		final String msg = cm.message() + " -- From line " + cm.lineNumber()
				+ " of " + cm.sourceId();

		if (level.compareTo(MessageLevel.DEBUG) == 0) {
			Log.d(Constants.LOG_TAG, msg);
		} else if (level.compareTo(MessageLevel.ERROR) == 0) {
			Log.e(Constants.LOG_TAG, msg);
		} else if (level.compareTo(MessageLevel.WARNING) == 0) {
			Log.w(Constants.LOG_TAG, msg);
		} else {
			Log.d(Constants.LOG_TAG, msg);
		}

		return true;
	}
	

}
