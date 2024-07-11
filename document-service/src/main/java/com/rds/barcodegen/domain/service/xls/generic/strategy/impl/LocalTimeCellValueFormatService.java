package com.rds.barcodegen.domain.service.xls.generic.strategy.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.rds.barcodegen.domain.service.xls.generic.XLSColumn;
import com.rds.barcodegen.domain.service.xls.generic.strategy.XlsCellValueStrategyService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.stereotype.Service;

import static com.rds.barcodegen.domain.service.xls.generic.strategy.impl.XLSCellDataType.LOCAL_TIME;
import static org.apache.commons.lang.StringUtils.isEmpty;

@Service
public class LocalTimeCellValueFormatService implements XlsCellValueStrategyService {

	@Override
	public void setCellValue(Cell cell, Object value, XLSColumn column, Workbook workbook) {
		String format = isEmpty(column.format()) ? "HH:mm:ss" : column.format();
		cell.setCellValue(((LocalTime) value).format(DateTimeFormatter.ofPattern(format)));
	}

	@Override
	public boolean supports(XLSCellDataType xlsCellDataType) {
		return xlsCellDataType.equals(LOCAL_TIME);
	}

}
