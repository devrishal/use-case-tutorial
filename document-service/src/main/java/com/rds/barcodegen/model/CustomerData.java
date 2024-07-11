package com.rds.barcodegen.model;

import com.rds.barcodegen.domain.service.xls.generic.XLSColumn;
import lombok.Data;

@Data
public class CustomerData {

	@XLSColumn(columnIndex = 0, headerName = "Customer Id")
	private long customerId;

	@XLSColumn(columnIndex = 1, headerName = "Email Address")
	private String emailAddress;

	@XLSColumn(columnIndex = 2, headerName = "Full Name")
	private String fullName;

}
