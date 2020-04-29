package com.example.project.resourceserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table("invoices")
public class Invoice {
	
	@Id
	private int id;
	private String invoiceNumber;
	private String dateOfInvoice;
	private String description;
	private String amount;
	private Status status;
	private UserModel userModel;
	
}
