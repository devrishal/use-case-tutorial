package com.rds.barcodegen.domain.service.xls.generic.strategy;

import com.rds.barcodegen.domain.service.xls.generic.strategy.impl.XLSCellDataType;
import com.rds.barcodegen.domain.service.xls.generic.XLSColumn;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.plugin.core.Plugin;

public interface XlsCellValueStrategyService extends Plugin<XLSCellDataType> {

	void setCellValue(Cell cell, Object value, XLSColumn column, Workbook workbook);

}
