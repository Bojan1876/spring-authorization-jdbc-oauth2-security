package com.example.project.resourceserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("invoices")
public class Invoice {

	@Id
	private Long id;
	//oovo mogu menjati kroz approve
	private String invoiceNumber;
	private String dateOfInvoice;
	private String description;
	private String amount;
	
	//kada je approved ne mogu menjati status, niti updatovati, niti brisati
	private InvoiceStatus status;

}
