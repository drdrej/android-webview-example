package com.significantfiles.mrcounter.db;

import com.significantfiles.android.sqlite.query.QueryType;

public class UnknownQueryTypeException extends RuntimeException {

	public UnknownQueryTypeException(final QueryType queryType) {
		super(createMessage(queryType));
	}

	private static String createMessage(final QueryType queryType) {
		return "QueryType is not supported [type = " + queryType + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
