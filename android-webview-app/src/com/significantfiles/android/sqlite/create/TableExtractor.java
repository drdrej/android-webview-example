package com.significantfiles.android.sqlite.create;

import com.significantfiles.android.provider.table.SQLiteTable;

public class TableExtractor {

	private Class<?> type;
	private SQLiteTable table;

	public void set(final Class<?> type) {
		this.type = type;
		this.table = this.type.getAnnotation(SQLiteTable.class);
	}

	public String getIfTableNotExists() {
		return (table.ifNotExists() ? " IF NOT EXISTS " : "");
	}

	public String getName() {
		return this.type.getSimpleName();
	}

	/**
	 * 
	 * @param typeDefinition
	 * 
	 * @return an empty String if table is not temporary. else 'TEMP'
	 */
	public String getTempTableFlag() {
		return (table.temp() ? "TEMP" : "");
	}

}