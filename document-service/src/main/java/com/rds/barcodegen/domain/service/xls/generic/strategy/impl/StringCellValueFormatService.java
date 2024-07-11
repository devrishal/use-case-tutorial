package com.rds.barcodegen.domain.service.xls.generic.strategy.impl;

import com.rds.barcodegen.domain.service.xls.generic.XLSColumn;
import com.rds.barcodegen.domain.service.xls.generic.strategy.XlsCellValueStrategyService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import static com.rds.barcodegen.domain.service.xls.generic.strategy.impl.XLSCellDataType.STRING;

@Service
@RequiredArgsConstructor
public class StringCellValueFormatService implements XlsCellValueStrategyService {

	private final MessageSource messageSource;

	@Override
	public void setCellValue(Cell cell, Object value, XLSColumn column, Workbook workbook) {
		if (column.isInternationalized()) {
			String internationalizedValue = messageSource.getMessage(column.internationalizationKey() + value, null,
					LocaleContextHolder.getLocale());
			cell.setCellValue(internationalizedValue);
		}
		else {
			cell.setCellValue(value.toString());
		}
	}

	@Override
	public boolean supports(XLSCellDataType xlsCellDataType) {
		return xlsCellDataType.equals(STRING);
	}

}
