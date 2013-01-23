package com.significantfiles.mrcounter.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

public class ContentResolverUtil {

	
	public static final void insert(final ContentResolver resolver, final String uriStr, final ContentValues values ) {
		final Uri uri = Uri.parse(uriStr);
		
		resolver.insert(uri, values);
	}
}
