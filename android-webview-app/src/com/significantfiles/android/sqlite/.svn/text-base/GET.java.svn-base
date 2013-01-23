package com.significantfiles.android.sqlite;

import android.database.Cursor;
import android.provider.Contacts.People;

public class GET {

	public static String string( final Cursor cursor, final String key ) {
		final int columnIdx = cursor.getColumnIndexOrThrow( key );

		return cursor.getString(columnIdx);
	}
	
	public static int integer( final Cursor cursor, final String key) {
		final int columnIdx = cursor.getColumnIndexOrThrow(People.NUMBER_KEY);

        return cursor.getInt(columnIdx);
		
	}
}
