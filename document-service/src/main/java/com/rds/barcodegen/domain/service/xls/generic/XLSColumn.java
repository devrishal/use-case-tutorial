package com.rds.barcodegen.domain.service.xls.generic;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
public @interface XLSColumn {

	String headerName() default "";

	int columnIndex() default 0;

	String format() default "";

	boolean isInternationalized() default false;

	String internationalizationKey() default "";

}
