package com.significantfiles.android.db;

import android.content.Context;
import android.test.ActivityTestCase;

import com.significantfiles.android.sqlite.commands.CreateTable;
import com.significantfiles.mrcounter.db.Credit;

public class SQLiteCreateTableTestCase extends ActivityTestCase {

	public void testBuildQuery() {
		final String query = CreateTable.buildQuery(Credit.class);
		assertNotNull( query );
		
//		final Context context = getActivity().getApplicationContext();
//		
	}

}
