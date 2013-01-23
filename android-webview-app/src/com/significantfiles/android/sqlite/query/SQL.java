package com.significantfiles.android.sqlite.query;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation to create Queries like described in the spec:
 * 
 * http://www.sqlite.org/lang_insert.html
 * 
 * @author asiebert
 * 
 */
@Target({ METHOD })
@Retention(RUNTIME)
public @interface SQL {

	String query();

	QueryType type() default QueryType.SELECT;

	String path();
}
