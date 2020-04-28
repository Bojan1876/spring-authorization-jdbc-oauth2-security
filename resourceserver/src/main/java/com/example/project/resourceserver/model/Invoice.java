package com.example.project.resourceserver.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Invoice {
	
	private int id;
	private String invoice_number;
	private String date_of_invoice;
	private String description;
	private String amount;
	private Status status;
	private UserModel user_model;
	
}
