package com.rds.barcodegen.domain.service.xls.generic.strategy.impl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum XLSCellDataType {

	LONG("Long"), STRING("String"), INTEGER("Integer"), LOCAL_TIME("LocalTime"), LOCAL_DATE("LocalDate"),
	DOUBLE("Double"), OBJECT("Object");

	private final String className;

	public static XLSCellDataType fromValue(String className) {
		for (XLSCellDataType cellDataType : values()) {
			if (cellDataType.className.equalsIgnoreCase(className)) {
				return cellDataType;
			}
		}
		return OBJECT;
	}

}
