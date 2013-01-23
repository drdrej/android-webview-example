package com.significantfiles.mrcounter.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.significantfiles.android.provider.table.UriPathExt;
import com.significantfiles.android.sqlite.commands.DaoManager;
import com.significantfiles.android.sqlite.commands.InsertCmd;

// TODO: Check Multithreading in initialised instances.

/**
 * This Operation executes an insert of a complex object 
 * into persistent-storage.
 */
@UriPathExt(uri="credit/new")
public class InsertCreditCmd extends InsertCmd implements ContentProviderCmd {

//	private Uri commandUri;

	private ContentValues values;
	private final DaoManager manager;

//	public InsertCreditCmd(final Uri commandUri,
//			final ContentValues values, final DaoManager daoManager) {
//		this.commandUri = commandUri;
//		this.values = values;
//		this.manager = daoManager;
//	}

	public InsertCreditCmd(final DaoManager daoManager) {
		this.manager = daoManager;
	}

	@Override
	public void exec(final SQLiteDatabase db) {
		final CreditDao dao = manager.build(CreditDao.class);

		final long contactId = extractContractId();
		final double value = extractValue();

		dao.newCredit(contactId, value, System.currentTimeMillis());
	}

	private double extractValue() {
		final String key = ContentValuesKeys.CREDIT_VALUE.name();

		return this.values.getAsDouble(key);
	}

	private long extractContractId() {
		final String key = ContentValuesKeys.CREDIT_BY.name();

		return this.values.getAsLong(key);
	}

	public void notifyChanges() {
//		final Uri newUri = this.commandUri;
//		;
//		

//		final Uri valueIdUri = 
//		getContext().getContentResolver().notifyChange(valueIdUri, null);
		
	}

}
