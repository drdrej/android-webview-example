package com.significantfiles.mrcounter.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.significantfiles.android.sqlite.commands.CreateTable;
import com.significantfiles.mrcounter.Constants;

/**
 * Work with the database (sqlite) for credits. In the Database will be stored
 * every credit.
 * 
 * @author Andreas Siebert
 */
public class CreditSQLiteOpenHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "mrcounter";

	public CreditSQLiteOpenHelper(final Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onUpgrade(final SQLiteDatabase db, final int oldVersion,
			final int newVersion) {
		final String logMsg = "Upgrading Database from Version [= "
				+ oldVersion + "] to Version [= " + newVersion + "].";

		Log.w(Constants.LOG_TAG, logMsg);

		final String sql = "DROP TABLE IF EXISTS " + DATABASE_NAME + ".credit";
		db.execSQL( sql );
		
		onCreate(db);
	}

	@Override
	public void onCreate(final SQLiteDatabase db) {
		Log.i(Constants.LOG_TAG, "Create new Database for DebitToy.");

		final String newCreditTable = CreateTable.buildQuery(Credit.class);

		Log.d(Constants.LOG_TAG, "Create Table based on query [= " + newCreditTable + "]");
		db.execSQL(newCreditTable);
	}

}
