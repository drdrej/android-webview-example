package com.significantfiles.android.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.net.Uri;
import android.test.ProviderTestCase2;

import com.significantfiles.mrcounter.db.provider.CreditContentProvider;


/*
 * http://stackoverflow.com/questions/82875/how-do-i-list-the-tables-in-a-sqlite-database-file
 */
public class SimpleProviderTestCase extends ProviderTestCase2<CreditContentProvider> {

	private static final int MATCH_CREDIT_URI = 0;

	private UriMatcher matcher;

	public SimpleProviderTestCase() {
		super(CreditContentProvider.class, CreditContentProvider.AUTHORITY );
	} 
	
    @Override
    protected void setUp() throws Exception {
    	super.setUp();
    
    	getMockContext().deleteDatabase( "mrcounter" );
    	
    	this.matcher = new UriMatcher(UriMatcher.NO_MATCH);
    	matcher.addURI( CreditContentProvider.AUTHORITY, "credit/#", MATCH_CREDIT_URI);
    }

	public void testInsertCredit() {
		final ContentResolver resolver = getMockContentResolver();
		
		assertNotNull( resolver );
		
		final String uriStr = "content://" + CreditContentProvider.AUTHORITY + "/credit/new"; 
		final Uri uri = Uri.parse( uriStr );
		
		final Uri newCreditUri = resolver.insert(uri, new ContentValues());
		
		assertNotNull( newCreditUri );
		
		int match = this.matcher.match( newCreditUri );
		assertEquals(MATCH_CREDIT_URI, match);
	}
}
