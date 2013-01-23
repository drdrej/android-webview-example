package com.significantfiles.android.db;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.test.AndroidTestCase;

import com.significantfiles.android.provider.table.Authority;
import com.significantfiles.android.provider.table.UriPathExt;
import com.significantfiles.android.sqlite.commands.CommandBasedContentProvider;
import com.significantfiles.mrcounter.db.CommandUriMatcher;
import com.significantfiles.mrcounter.db.ContentProviderCmd;
import com.significantfiles.mrcounter.db.provider.CommandBasedCreditContentProvider;


// http://books.google.de/books?id=Bam8K5SIiTkC&pg=PA105&lpg=PA105&dq=android+UriMatcher+returns+-1&source=bl&ots=NGImB6ONSY&sig=SP3UWzQBsGt4xl7H-AoV5UDZ3Pk&hl=de&ei=4BY7TeX0OcTxsgbsp9HzBg&sa=X&oi=book_result&ct=result&resnum=2&ved=0CCAQ6AEwAQ#v=onepage&q&f=false
// https://github.com/plans
// https://github.com/der-harm/CouchOneProvider/blob/master/src/de/harm/android/couchone/common/CouchConstants.java
// http://www.assembla.com/wiki/show/breakoutdocs/Assembla_REST_API
// http://www.google.com/enterprise/marketplace/search?categoryId=4&orderBy=RATING&offset=10

// http://www.fm.nrw.de/allgemein_fa/service/formulare/est/01_est_jahr/2009/27_anlage_g_2009_bmf.pdf
// http://www.fm.nrw.de/allgemein_fa/service/formulare/est/01_est_jahr/2009/01_est1a_2009_bmf.pdf

// 

public class CommandUriMatcherTestCase extends AndroidTestCase {

	public static final String AUTHORITY = "sqleasytest";

	public static final String NoOpCommand_PATH_EXT = "no";	

	
	public void testUriMatcher() {
		UriMatcher m = new UriMatcher(UriMatcher.NO_MATCH);
		
		String auth = "sqleasy";
		
		Uri uri2 = Uri.parse( "content://sqleasy/uri/10" );
		
		String path2 = "uri/#";

		m.addURI(auth, path2, 1);
		
		
		Uri uri = Uri.parse( "content://sqleasy/uri" );
		
		String path = uri.getPath();
			
		m.addURI(auth, "uri", 2);

		int match = m.match( uri );
		int match2 = m.match( uri2 );
		
		assertEquals(2, match);
		assertEquals(1, match2);
	}

	public void testSimpleRegisterAndMatch() {
		final CommandUriMatcher matcher = new CommandUriMatcher(TestNoOpProvider.class);
		
		final NoOpCommand cmd = new NoOpCommand();
		matcher.register( cmd );
		
		final String uri = "content://" + AUTHORITY + "/" + NoOpCommand_PATH_EXT;
		final ContentProviderCmd matchedCmd = matcher.match(uri);
		
		assertSame(cmd, matchedCmd);
	}
	
	@Authority( uri= AUTHORITY )
	static class TestNoOpProvider extends CommandBasedContentProvider {

		@Override
		public int delete(Uri uri, String selection, String[] selectionArgs) {
			return 0;
		}

		@Override
		public String getType(Uri uri) {
			return null;
		}

		@Override
		public Uri insert(Uri uri, ContentValues values) {
			return null;
		}

		@Override
		public boolean onCreate() {
			return false;
		}

		@Override
		public Cursor query(Uri uri, String[] projection, String selection,
				String[] selectionArgs, String sortOrder) {
			return null;
		}

		@Override
		public int update(Uri uri, ContentValues values, String selection,
				String[] selectionArgs) {
			return 0;
		}
	
	}
	
	@UriPathExt(uri=NoOpCommand_PATH_EXT)
	static class NoOpCommand implements ContentProviderCmd {

		@Override
		public void notifyChanges() {
			;
		}

		@Override
		public void exec(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
		}

	}
}
