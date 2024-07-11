package com.rds.barcodegen.domain.service.xls.generic.strategy.impl;

import com.rds.barcodegen.domain.service.xls.generic.XLSColumn;
import com.rds.barcodegen.domain.service.xls.generic.strategy.XlsCellValueStrategyService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.stereotype.Service;

import static com.rds.barcodegen.domain.service.xls.generic.strategy.impl.XLSCellDataType.OBJECT;

@Service
public class DefaultCellValueFormatService implements XlsCellValueStrategyService {

	@Override
	public void setCellValue(Cell cell, Object value, XLSColumn column, Workbook workbook) {
		cell.setCellValue(value.toString());
	}

	@Override
	public boolean supports(XLSCellDataType xlsCellDataType) {
		return xlsCellDataType.equals(OBJECT);
	}

}
