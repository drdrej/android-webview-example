package com.significantfiles.android.provider.table.constraint;

import com.significantfiles.android.provider.table.OrderBy;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target({ METHOD }) @Retention(RUNTIME)
public @interface IsPrimaryKey {

	String name() default "";
	
	OrderBy order() default OrderBy.ASC;

	boolean autoIncrement() default false;
	
	String msg() default "";
	
}
