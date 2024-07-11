package com.rds.barcodegen.api.rest;

import java.io.IOException;

import com.rds.barcodegen.api.swagger.DocumentResponse;
import com.rds.barcodegen.model.OrderDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface DocumentResource {

	@DocumentResponse
	@Operation(summary = "Download PDF with Code39 Barcode")
	@GetMapping(path = "/barcodes")
	void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

	@DocumentResponse
	@Operation(summary = "Download PDF for Bills")
	@PostMapping(path = "/bills")
	void downloadBill(@RequestBody OrderDetail orderDetail, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;

	@DocumentResponse
	@Operation(summary = "Download XLS document")
	@GetMapping(path = "/documents/generic")
	void downloadXlsGenericDocument(
			@RequestParam @Parameter(description = "Document Name", example = "TestDocument") String docName,
			HttpServletRequest request, HttpServletResponse response);

	@DocumentResponse
	@Operation(summary = "Download XLS document")
	@GetMapping(path = "/documents")
	void downloadXlsDocument(
			@RequestParam @Parameter(description = "Document Name", example = "TestDocument") String docName,
			HttpServletRequest request, HttpServletResponse response);

}
