package com.significantfiles.mrcounter.db;

import com.significantfiles.android.provider.table.Authority;
import com.significantfiles.android.provider.table.OrderBy;
import com.significantfiles.android.provider.table.SQLiteField;
import com.significantfiles.android.provider.table.SQLiteTable;
import com.significantfiles.android.provider.table.constraint.IsPrimaryKey;
import com.significantfiles.android.provider.table.constraint.NotNull;
import com.significantfiles.android.sqlite.types.INTEGER;
import com.significantfiles.android.sqlite.types.REAL;

@SQLiteTable(temp = false, ifNotExists = true, dbName="mrcounter" )
public interface Credit {

	@SQLiteField
	@IsPrimaryKey(order=OrderBy.ASC, autoIncrement=true)
	@NotNull
	public INTEGER _ID();

//	public static final String ID = "ID";
	
	@SQLiteField
	public REAL CREDIT_VALUE();
	
//	public String CREDIT_VALUE = "CREDIT_VALUE";
	
	@SQLiteField
	@NotNull
	public INTEGER CREDIT_BY();

	@SQLiteField
	@NotNull
	public INTEGER CREATED_AT();
	
	@SQLiteField
	@NotNull
	public INTEGER MODIFIED_AT();

	
}
