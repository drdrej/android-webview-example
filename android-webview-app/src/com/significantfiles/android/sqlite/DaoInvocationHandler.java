package com.significantfiles.android.sqlite;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import com.significantfiles.android.sqlite.query.QueryType;
import com.significantfiles.android.sqlite.query.SQL;
import com.significantfiles.mrcounter.db.UnknownQueryTypeException;

public class DaoInvocationHandler implements InvocationHandler {

	private final DaoMethod daoMethodCall = new DaoMethod();

	private final Class<?> daoType;

	private final SQLiteOpenHelper dbManager;
	
	public DaoInvocationHandler(final Class<?> daoType, final SQLiteOpenHelper dbManager) {
		this.daoType = daoType;
		this.dbManager = dbManager;
	}


	@Override
	public Object invoke(final Object proxy, final Method method,
			final Object[] arguments) throws Throwable {

		daoMethodCall.set(method);

		final QueryType queryType = daoMethodCall.queryType();
		switch (queryType) {
		case SELECT:
			throw new UnsupportedOperationException();
		case INSERT:
			return handleInsertSQL(arguments);
		default:
			handleUnknownQueryType(queryType);
			break;
		}

		// TODO Auto-generated method stub
		return null;
	}

	private Object handleInsertSQL(final Object[] arguments) {
		final String sql = daoMethodCall.buildSQL();
		
		execQuery(sql, arguments);
		
		return null;
	}


	private void execQuery(final String sql, final Object[] arguments) {
		Log.i("sqleasy", "Execute sql [= " + sql + "] on SQLite-Database over DAO [= " + this.daoType.getName() + "]." );
		final SQLiteDatabase db = this.dbManager.getWritableDatabase();
		
//		db.beginTransaction();
//		db.query("Credit", , selection, selectionArgs, groupBy, having, orderBy)
//		db.rawQuery( "SELECT * from sqlite_master WHERE", selectionArgs)
//		
		try {
		    db.execSQL(sql, arguments);
		} catch (final Throwable e) {
			throw new InsertException(sql, arguments, e);
		}
		
//		db.endTransaction();
	}


	private void handleUnknownQueryType(final QueryType queryType) {
		throw new UnknownQueryTypeException(queryType);
	}

	static class DaoMethod {

		private Method method;
		private SQL sql;

		public void set(final Method method) {
			this.method = method;
			this.sql = this.method.getAnnotation(SQL.class);
		}

		public String buildSQL() {
			return this.sql.query();
		}

		private Uri buildURI() {
			throw new UnsupportedOperationException();
		}

		public QueryType queryType() {
			return sql.type();
		}
		
	}
}