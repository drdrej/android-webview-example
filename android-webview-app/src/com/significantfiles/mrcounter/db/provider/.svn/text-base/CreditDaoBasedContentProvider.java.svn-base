package com.significantfiles.mrcounter.db.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.significantfiles.android.sqlite.UnsupportedUri;
import com.significantfiles.android.sqlite.commands.CommandBasedContentProvider;
import com.significantfiles.android.sqlite.commands.DaoManager;
import com.significantfiles.mrcounter.Constants;
import com.significantfiles.mrcounter.db.CommandUriMatcher;
import com.significantfiles.mrcounter.db.CreditDao;
import com.significantfiles.mrcounter.db.CreditSQLiteOpenHelper;

public class CreditDaoBasedContentProvider extends CommandBasedContentProvider {

	public static String AUTHORITY = Constants.AUTHORITY;

    private static final UriMatcher matcher = initUriMatcher();

	private CreditSQLiteOpenHelper databaseHelper;

    /*
     * Uri-Matcher-Codes :::
     */
	private static final int MATCH_NEW_CREDIT = 0;

	private static UriMatcher initUriMatcher() {
		final UriMatcher rval = new UriMatcher(UriMatcher.NO_MATCH);
		
		rval.addURI(AUTHORITY, "credit/new", MATCH_NEW_CREDIT);
		
		return rval;
	}
	
	private DaoManager daoManager;
	
	public DaoManager getDaoManager() {
		return this.daoManager;
	}
	


	public CreditSQLiteOpenHelper getDatabaseHelper() {
		return databaseHelper;
	}


	protected void onRegisterCommands(final CommandUriMatcher matcher) {
//		final String path = matcher.getUriPath(InsertCreditCmd.class);
//		
//		final InsertCreditCmd cmd = new InsertCreditCmd();
//		
//		matcher.register( cmd );
	}

	@Override
	public boolean onCreate() {
		final Context context = getContext();
		this.databaseHelper = new CreditSQLiteOpenHelper(context);
		this.daoManager = new DaoManager( this.databaseHelper );
		
		return true;
	}

	@Override
	public Cursor query(final Uri uri, final String[] projection,
			final String selection, final String[] selectionArgs,
			final String sortOrder) {

		throw new UnsupportedOperationException();
	}

	@Override
	public int delete(final Uri arg0, final String arg1, final String[] arg2) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getType(final Uri uri) {
		return "mrcounter/app";
	}

	@Override
	public Uri insert(final Uri uri, final ContentValues values) {
		final int match = matcher.match(uri);
		
		if( match != MATCH_NEW_CREDIT ) {
			throw new UnsupportedUri(uri);
		}
		
		final CreditDao build = this.daoManager.build(CreditDao.class);
		
		long creditValue = 0;
		
		// TODO: sollte die neue URI zurück geben?
//		long creditId = 
		build.newCredit(creditValue, 0.0, 0);

		return createNewCreditResultUri(1);
	}

	private Uri createNewCreditResultUri(final long creditId) {
		final String uriStr = "content://" + AUTHORITY + "/credit/" + creditId;
		
		return Uri.parse( uriStr );
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		throw new UnsupportedOperationException();
	}

}
