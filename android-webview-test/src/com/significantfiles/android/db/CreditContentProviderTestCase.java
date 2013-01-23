package com.significantfiles.android.db;

import com.significantfiles.mrcounter.Constants;
import com.significantfiles.mrcounter.db.ContentValuesKeys;
import com.significantfiles.mrcounter.db.provider.CommandBasedCreditContentProvider;
import com.significantfiles.mrcounter.db.provider.CreditDaoBasedContentProvider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.test.ProviderTestCase2;
import junit.framework.TestCase;

public class CreditContentProviderTestCase extends ProviderTestCase2<CreditDaoBasedContentProvider> {

	private static final String AUTHORITY = Constants.AUTHORITY;
    private static final String CONTENT_STR = "content://";
	
	public CreditContentProviderTestCase(String name) {
		super(CreditDaoBasedContentProvider.class, AUTHORITY );
	}


	
	public void testInsertCredit() {
		final String uriStr = CONTENT_STR + AUTHORITY + "/"  + "credit/new";
		final Uri uri = Uri.parse( uriStr );
		
		final ContentResolver resolver = getContext().getContentResolver();
		
		final ContentValues values = new ContentValues();
		values.put(ContentValuesKeys.CREDIT_BY.name(), (long) 0);
		values.put(ContentValuesKeys.CREDIT_VALUE.name(), (double) 1.0 );
		
		final Uri newCreditUri = resolver.insert(uri, values);
		
		assertNotNull( newCreditUri );
	}
	

}
