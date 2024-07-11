package com.rds.barcodegen.domain.service.xls.generic.strategy.impl;

import com.rds.barcodegen.domain.service.xls.generic.XLSColumn;
import com.rds.barcodegen.domain.service.xls.generic.strategy.XlsCellValueStrategyService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.stereotype.Service;

import static com.rds.barcodegen.domain.service.xls.generic.strategy.impl.XLSCellDataType.LONG;
import static org.apache.commons.lang.StringUtils.isEmpty;

@Service
public class LongCellValueFormatService implements XlsCellValueStrategyService {

	@Override
	public void setCellValue(Cell cell, Object value, XLSColumn column, Workbook workbook) {
		if (!isEmpty(column.format())) {
			CellStyle cellStyle = workbook.createCellStyle();
			DataFormat dataFormat = workbook.createDataFormat();
			cellStyle.setDataFormat(dataFormat.getFormat(column.format()));
			cell.setCellStyle(cellStyle);
		}
		cell.setCellValue((Long) value);
	}

	@Override
	public boolean supports(XLSCellDataType xlsCellDataType) {
		return xlsCellDataType.equals(LONG);
	}

}
