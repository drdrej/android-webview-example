package com.significantfiles.android.provider.table;

import java.lang.reflect.Method;
import java.util.Enumeration;

import com.significantfiles.mrcounter.Constants;

import android.util.Log;

public final class ColumnMethodEnumeration implements
		Enumeration<Method> {
	
	private final Method[] methods;
	private Method cursor = null;
	private int index = -1;

	public ColumnMethodEnumeration(final Class<?> typeDefinition) {
		this.methods = typeDefinition.getMethods();
	}

	@Override
	public boolean hasMoreElements() {
		final boolean hasNoMoreEntries = (index >= methods.length);
		if (hasNoMoreEntries) {
			return false;
		}

		if (cursor == null) {
			return loadNextMethod();
		}

		return true;
	}

	private boolean loadNextMethod() {
		for (int i = (index + 1); i < methods.length; i++) {
			final Method method = methods[i];

			if (isTableField(method)) {
				this.cursor = method;
				this.index = i;
				break;
			}
		}

		return this.cursor != null;
	}

	private boolean isTableField(final Method method) {
		final SQLiteField annotation = method
				.getAnnotation(SQLiteField.class);

		if (annotation == null)
			return false;

		final Class<?> returnType = method.getReturnType();

		final boolean isCorrectReturnType = (returnType.isInterface() && isSQLiteType(returnType));

		return (isCorrectReturnType);
	}

	private boolean isSQLiteType(final Class<?> returnType) {
		return SQLiteType.class.isAssignableFrom(returnType);
	}

	@Override
	public Method nextElement() {
		if (cursor == null) {
			final String logMsg = "Couldn't find next method. Cursor is broken or miss-used [cursor = NULL]";
			Log.e( Constants.LOG_TAG, logMsg);

			throw new IllegalStateException();
		}

		final Method rval = cursor;
		cursor = null;
		return rval;
	}
}