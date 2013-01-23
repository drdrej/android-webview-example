package com.significantfiles.android.sqlite;

import android.net.Uri;

public class UnsupportedUri extends RuntimeException {

	public UnsupportedUri(final Uri uri) {
		super(createMsg(uri));
	}

	private static String createMsg(final Uri uri) {
		return "Uri is not supported [uri = " + uri + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
