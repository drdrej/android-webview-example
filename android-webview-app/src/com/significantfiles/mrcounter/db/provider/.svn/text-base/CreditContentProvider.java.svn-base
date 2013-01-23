package com.significantfiles.mrcounter.db.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import com.significantfiles.android.sqlite.UnsupportedUri;
import com.significantfiles.android.sqlite.commands.DaoManager;
import com.significantfiles.mrcounter.Constants;
import com.significantfiles.mrcounter.db.Credit;
import com.significantfiles.mrcounter.db.CreditDao;
import com.significantfiles.mrcounter.db.CreditSQLiteOpenHelper;

/**
 * first version of CreditContentProvider, based on DAO and Uri-Matcher.
 * 
 * @author Andreas Siebert, significantfiles.com
 */
public class CreditContentProvider extends ContentProvider {

	public static String AUTHORITY = Constants.AUTHORITY;

    private static final UriMatcher MATCHER = initUriMatcher();

    /*
     * Uri-Matcher-Codes :::
     */
	private static final int MATCH_NEW_CREDIT = 0;
	private static final int MATCH_DEL_BY_ID = 1;
	private static final int MATCH_SELECT_BY_ID = 2;
	private static final int MATCH_SELECT_ALL = 3;
	
	private static UriMatcher initUriMatcher() {
		final UriMatcher rval = new UriMatcher(UriMatcher.NO_MATCH);
		
		rval.addURI(AUTHORITY, "credit/new", MATCH_NEW_CREDIT);
		rval.addURI(AUTHORITY, "credit/del/#", MATCH_DEL_BY_ID);
        rval.addURI(AUTHORITY, "credit/#", MATCH_SELECT_BY_ID);
        
		return rval;
	}

	private CreditSQLiteOpenHelper database;

	private DaoManager daoManager;

	@Override
	public boolean onCreate() {
		final Context context = getContext();
		this.database = new CreditSQLiteOpenHelper(context);
		this.daoManager = new DaoManager(database);
		
		return true;
	}

	@Override
	public int delete(Uri uri, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(final Uri uri) {
		switch ( MATCHER.match(uri) ) {
		case MATCH_SELECT_BY_ID:
			return "vnd.android.cursor.item/credit";
		case MATCH_SELECT_ALL:
			return "vnd.android.cursor.dir/credits";
		default:
			throw new UnsupportedUri(uri);
		}
	}

	@Override
	public Uri insert(final Uri uri, ContentValues arg1) {
		
		final int match = MATCHER.match( uri );

		final CreditDao dao = this.daoManager.build( CreditDao.class );
		
		final long now = System.currentTimeMillis();
		dao.newCredit(1, 1.0, now);
		
		if( match != MATCH_NEW_CREDIT )
			throw new UnsupportedUri( uri );
	
		final String newElementQuery = "content://" + AUTHORITY + "/credit/" + now;

		return Uri.parse( newElementQuery );
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3,
			String arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
