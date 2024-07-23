package com.rds.barcodegen.domain.service.xls;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.rds.barcodegen.domain.repository.CustomerRepository;
import com.rds.barcodegen.exception.DocumentServiceException;
import com.rds.barcodegen.model.CustomerData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class CustomerXLSUsualDocumentService {

	private final CustomerRepository customerRepository;

	private final ModelMapper modelMapper;

	public void generateXlsDocument(String docName, HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        response.setStatus(OK.value());
        response.setHeader(CONTENT_DISPOSITION, "attachment;filename=" + docName + ".xlsx");

		List<CustomerData> data = customerRepository.findAll()
			.stream()
			.map(customer -> modelMapper.map(customer, CustomerData.class))
			.toList();

        if (isEmpty(data)) {
            throw new DocumentServiceException("No data to generate document");
        }

		try (var workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet(docName);
			createHeaderRow(sheet);
			createDataRows(sheet, data);
			workbook.write(response.getOutputStream());
		}
		catch (IOException e) {
			throw new DocumentServiceException(e.getMessage());
		}
	}

	private void createHeaderRow(Sheet sheet) {
		Row headerRow = sheet.createRow(0);
		String[] headers = { "Customer Id", "Email Address", "Full Name" };
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
		}
	}

	private void createDataRows(Sheet sheet, List<CustomerData> data) {
		for (int i = 0; i < data.size(); i++) {
			Row row = sheet.createRow(i + 1);
			createDataCell(row, 0, data.get(i).getCustomerId());
			createDataCell(row, 1, data.get(i).getFullName());
			createDataCell(row, 2, data.get(i).getEmailAddress());
		}
	}

	private void createDataCell(Row row, int columnIndex, Object value) {
		Cell cell = row.createCell(columnIndex);
		if (null != value) {
			switch (value.getClass().getSimpleName()) {
				case "Integer":
					cell.setCellValue((Integer) value);
					break;
				case "Boolean":
					cell.setCellValue((Boolean) value);
					break;
				case "Long":
					cell.setCellValue((Long) value);
					break;
				case "LocalDate":
					cell.setCellValue(((LocalDate) value).format(ofPattern("dd/MM/yyyy")));
					break;
				case "LocalTime":
					cell.setCellValue(((LocalTime) value).format(ofPattern("HH:mm:ss")));
					break;
				default:
					cell.setCellValue(value.toString());
					break;
			}
		}
		else {
			cell.setCellValue(EMPTY);
		}
	}

}
