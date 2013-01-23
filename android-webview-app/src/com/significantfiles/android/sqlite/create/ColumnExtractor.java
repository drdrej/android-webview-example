package com.significantfiles.android.sqlite.create;

import java.lang.reflect.Method;

import com.significantfiles.android.provider.table.OrderBy;
import com.significantfiles.android.provider.table.constraint.IsPrimaryKey;

public class ColumnExtractor {

	private static final String PRIMARY_KEY = " PRIMARY KEY ";

	private Method method;

	public void set(final Method method) {
		this.method = method;
	}

	/**
	 * Build primary-constraint for the CREATE-Table query.
	 * 
	 * @return
	 */
	public String getPrimaryKeyConstraint() {
		final IsPrimaryKey field = this.method
				.getAnnotation(IsPrimaryKey.class);

		if (field == null)
			return "";

		final StringBuilder buffer = new StringBuilder(128);

		final boolean hasName = (field.name().length() > 0);

		if (hasName) {
			buffer.append(" CONSTRAINT ");
			buffer.append(field.name());
			buffer.append(" ");
		}

		buffer.append(PRIMARY_KEY);

		final OrderBy order = field.order();

		switch (order) {
		case DESC:
			buffer.append(" DESC ");
			break;
		case ASC:
			buffer.append(" ASC ");
			break;
		}
		
		final String msg = field.msg().trim();
		if( msg.length() > 0) {
			buffer.append( " " );
			buffer.append( msg );
			buffer.append( " " );
		}
		
		if (field.autoIncrement()) {
			buffer.append(" AUTOINCREMENT ");
		}

		return buffer.toString();
	}

	public String getName() {
		return this.method.getName();
	}

	public String getColumnType() {
		final Class<?> rtype = this.method.getReturnType();

		return rtype.getSimpleName();
	}
	
}