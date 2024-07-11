package com.rds.barcodegen.domain.service.xls.generic.writer;

import java.util.List;

import com.rds.barcodegen.domain.repository.CustomerRepository;
import com.rds.barcodegen.model.CustomerData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerXlsDocumentService {

	private final CustomerRepository customerRepository;

	private final XLSDocumentWriter<CustomerData> documentWriter;

	private final ModelMapper modelMapper;

	public void generateXlsDocument(String docName, HttpServletResponse response) {
		List<CustomerData> customers = customerRepository.findAll()
			.stream()
			.map(customer -> modelMapper.map(customer, CustomerData.class))
			.toList();
		documentWriter.write(customers, docName, response);
	}

}
