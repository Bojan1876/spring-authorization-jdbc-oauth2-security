package com.example.project.resourceserver.modelDTO;

import com.example.project.resourceserver.model.InvoiceStatus;

import lombok.Data;

@Data
public class InvoiceDTO {

	private Long id;
	private String invoiceNumber;
	private String dateOfInvoice;
	private String description;
	private String amount;
	private InvoiceStatus status;
}
