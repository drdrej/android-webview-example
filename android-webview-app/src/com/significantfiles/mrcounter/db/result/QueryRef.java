package com.significantfiles.mrcounter.db.result;

public @interface QueryRef {

	String field();

	Class<? extends Converter<?,?>> converter() default DefaultConverterStrategy.class;

}
