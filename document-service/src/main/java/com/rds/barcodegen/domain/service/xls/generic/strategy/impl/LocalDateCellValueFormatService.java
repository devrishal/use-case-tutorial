package com.rds.barcodegen.domain.service.xls.generic.strategy.impl;

import java.time.LocalDate;

import com.rds.barcodegen.domain.service.xls.generic.XLSColumn;
import com.rds.barcodegen.domain.service.xls.generic.strategy.XlsCellValueStrategyService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.stereotype.Service;

import static com.rds.barcodegen.domain.service.xls.generic.strategy.impl.XLSCellDataType.LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang.StringUtils.isEmpty;

@Service
public class LocalDateCellValueFormatService implements XlsCellValueStrategyService {

	@Override
	public void setCellValue(Cell cell, Object value, XLSColumn column, Workbook workbook) {
		String format = isEmpty(column.format()) ? "dd/MM/yyyy" : column.format();
		cell.setCellValue(((LocalDate) value).format(ofPattern(format)));
	}

	@Override
	public boolean supports(XLSCellDataType xlsCellDataType) {
		return xlsCellDataType.equals(LOCAL_DATE);
	}

}
