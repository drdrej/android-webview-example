package com.significantfiles.mrcounter.db.result;

import com.significantfiles.android.sqlite.types.INTEGER;

public class DefautInteger2IntConverter implements Converter<INTEGER, Integer> {

	@Override
	public Integer from(final INTEGER input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getDefault() {
		return 0;
	}

	
}
