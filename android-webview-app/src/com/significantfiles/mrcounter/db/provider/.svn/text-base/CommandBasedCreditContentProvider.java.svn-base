package com.significantfiles.mrcounter.db.provider;


import com.significantfiles.android.provider.table.Authority;
import com.significantfiles.android.sqlite.commands.CommandBasedContentProvider;
import com.significantfiles.android.sqlite.commands.DaoManager;
import com.significantfiles.mrcounter.Constants;
import com.significantfiles.mrcounter.db.CommandUriMatcher;
import com.significantfiles.mrcounter.db.ContentProviderCmd;
import com.significantfiles.mrcounter.db.CreditQuery;
import com.significantfiles.mrcounter.db.CreditSQLiteOpenHelper;
import com.significantfiles.mrcounter.db.Credits;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

/**
 * http://developer.android.com/resources/samples/NotePad/src/com/example/android/notepad/NotePadProvider.html
 * http://developer.android.com/guide/topics/providers/content-providers.html
 * 
 * http://developer.android.com/guide/appendix/faq/commontasks.html
 * http://developer.android.com/guide/topics/data/data-storage.html
 * 
 * http://www.sqlite.org/lang_createtable.html
 * http://www.reigndesign.com/blog/using-your-own-sqlite-database-in-android-applications/
 * http://www.casarini.org/blog/2009/android-contentprovider-on-sqlite-tables-without-the-_id-column/
 * http://android-developers.blogspot.com/2010/07/multithreading-for-performance.html
 * 
 * http://www.assembla.com/wiki/show/breakoutdocs/Assembla_REST_API
 * 
 * http://www.spiegel.de/netzwelt/games/0,1518,740309,00.html
 * 
 * @author asiebert
 *
 */
@Authority( uri=Constants.AUTHORITY )
public class CommandBasedCreditContentProvider extends CommandBasedContentProvider {

	public static Uri CONTENT_URI;
	
	private CreditSQLiteOpenHelper databaseHelper;

	private final CommandUriMatcher commandMatcher = initCommandMatcher();

	private DaoManager daoManager;
	
	public DaoManager getDaoManager() {
		return this.daoManager;
	}
	
	public CreditSQLiteOpenHelper getDatabaseHelper() {
		return databaseHelper;
	}

	private CommandUriMatcher initCommandMatcher() {
		System.out.print( "init Matcher");
		
		final Class<? extends CommandBasedCreditContentProvider> providerClass = getClass();
		final CommandUriMatcher matcher = new CommandUriMatcher( providerClass );
		
		onRegisterCommands(matcher);
		
		return matcher;
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

		final SQLiteQueryBuilder builder = CreditQuery.buildQuery(uri);

		final String orderBy = buildOrderBy(sortOrder);

        final SQLiteDatabase db = databaseHelper.getReadableDatabase();

        
        final Cursor cursor = db.rawQuery("", null);
        
//        final Cursor cursor = builder.query(db, projection, selection, selectionArgs, null, null, orderBy);

        final ContentResolver resolver = getContext().getContentResolver();
        cursor.setNotificationUri(resolver, uri);
        
        return cursor;
	}

	private String buildOrderBy(final String sortOrder) {
        if (TextUtils.isEmpty(sortOrder)) {
            return Credits.DEFAULT_SORT_ORDER;
        } else {
            return sortOrder;
        }
	}

	@Override
	public int delete(final Uri arg0, final String arg1, final String[] arg2) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getType(final Uri uri) {
//		final int match = URI_MATCHER.match(uri);

		// TODO Auto-generated method stub
		return "sqleasy/test";
	}

	@Override
	public Uri insert(final Uri uri, final ContentValues values) {
		final SQLiteDatabase db = this.databaseHelper.getWritableDatabase();		
		final ContentProviderCmd command = this.commandMatcher.match(uri);
		
		command.exec(db);
		command.notifyChanges();
		
		return  null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		throw new UnsupportedOperationException();
	}

}
