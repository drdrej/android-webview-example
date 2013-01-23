package com.significantfiles.mrcounter.db.result;

public interface Converter<I, O> {

	public O from(final I input);
	
	public O getDefault();
	
}
