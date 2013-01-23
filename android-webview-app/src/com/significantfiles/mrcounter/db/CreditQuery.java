package com.significantfiles.mrcounter.db;


import com.significantfiles.mrcounter.Constants;

import android.content.UriMatcher;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

public enum CreditQuery {
	GetCreditById, 
	GetAllCredits;

	private static final UriMatcher MATCHER = createUriMatcher();

	public static final UriMatcher createUriMatcher() {
		final UriMatcher rval = new UriMatcher(UriMatcher.NO_MATCH);

		rval.addURI(Credits.AUTHORITY, GetCreditById.name(),
				GetCreditById.ordinal());

		return rval;
	}

	public static SQLiteQueryBuilder buildQuery(final Uri uri) {
		final SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
		builder.setTables(Credits.TABLE_NAME);

		final int match = MATCHER.match(uri);
		
		if( GetCreditById.ordinal() == match ) {

		} else if( GetAllCredits.ordinal() == match ) {

		} else {
			final String logMsg = "Couldn't execute uri. Unknown uri [= " + uri + "]";
			Log.w( Constants.LOG_TAG, logMsg);
			
			throw new IllegalArgumentException(logMsg);
		}
		
		return builder;
	}
}
