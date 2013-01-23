package com.significantfiles.android.sqlite.commands;

import java.lang.reflect.Method;
import java.util.Enumeration;

import com.significantfiles.android.provider.table.ColumnMethodEnumeration;
import com.significantfiles.android.provider.table.SQLiteTable;
import com.significantfiles.android.sqlite.create.ColumnExtractor;
import com.significantfiles.android.sqlite.create.TableExtractor;
import com.significantfiles.mrcounter.Constants;


import android.util.Log;

/**
 * This class provides static methods to build CREATE TABLE Queries based on
 * Java-Types.
 * 
 * Query-Documentation: http://www.sqlite.org/lang_createtable.html (BNF with
 * some descriptions)
 * 
 * @author Andreas Siebert, significantfiles.com
 * @version 1.0
 */
public class CreateTable {

	public static String buildQuery(final Class<?> typeDefinition) {
		if (typeDefinition == null) {
			final String logMsg = "Couldn't create query (CREATE TABLE ***) for passed type [= null]";
			Log.e( Constants.LOG_TAG, logMsg);

			throw new IllegalArgumentException("parameter:typeDefinition");
		}

		if (!isSQLiteTable(typeDefinition)) {
			final String logMsg = "Couldn't create query (CREATE TABLE ***) for passed type [= "
					+ typeDefinition.getName() + "]";
			Log.e( Constants.LOG_TAG, logMsg);

			throw new IllegalArgumentException(logMsg);
		}

		final StringBuilder queryBuffer = new StringBuilder(256);

		printQuery(typeDefinition, queryBuffer);

		return queryBuffer.toString();
	}

	private static void printQuery(final Class<?> typeDefinition,
			final StringBuilder queryBuffer) {
		// TODO: an dieser Stelle optionen aus der Annotation SQLiteTable
		// auslesen.
		// TODO: Extract as Object extrahieren.
		// Damit man mehr Objektorientiert entwickeln kann.
		final TableExtractor table = new TableExtractor();
		table.set(typeDefinition);

		queryBuffer.append("CREATE ");
		queryBuffer.append(table.getTempTableFlag());
		queryBuffer.append(" TABLE ");
		queryBuffer.append(table.getIfTableNotExists());
		queryBuffer.append(table.getName());
		queryBuffer.append(" ( ");

		boolean first = true;

		final ColumnExtractor x = new ColumnExtractor();

		for (final Enumeration<Method> columns = extractColumns(typeDefinition); columns
				.hasMoreElements(); first = false) {

			if (!first) {
				queryBuffer.append(", ");
			}

			// TODO: Handling of ID :::
			// TODO: more flexible for different SQLite-Query-Elements :::
			final Method column = columns.nextElement();
			x.set(column);

			queryBuffer.append(x.getName());
			queryBuffer.append(" ");
			queryBuffer.append( x.getColumnType() );
			queryBuffer.append( x.getPrimaryKeyConstraint() );
		}

		queryBuffer.append(" ); ");
	}

	private static Enumeration<Method> extractColumns(
			final Class<?> typeDefinition) {
		return new ColumnMethodEnumeration(typeDefinition);
	}

	private static boolean isSQLiteTable(final Class<?> typeDefinition) {
		final SQLiteTable annotation = typeDefinition
				.getAnnotation(SQLiteTable.class);

		return (annotation != null);
	}
}
