package com.significantfiles.mrcounter.db;

import com.significantfiles.mrcounter.db.provider.CreditContentProvider;

public interface Uris {

	public static final String INSERT_CREDIT = "content://" + CreditContentProvider.AUTHORITY + "/credit/new";
	
}
