package com.significantfiles.android.sqlite;

public class InsertException extends RuntimeException {

	public InsertException(final String sql, final Object[] arguments,
			final Throwable cause) {
		super(createMsg(sql, arguments), cause);
	}

	private static String createMsg(final String sql, final Object[] arguments) {
		return "Couldn't execute insert [sql = " + sql + "] on database [name = ...]";
	}

	private static final long serialVersionUID = 1L;

}
