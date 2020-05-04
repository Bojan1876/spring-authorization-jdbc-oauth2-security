package com.example.project.resourceserver.modelDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceDTO {

	private Long id;
	private String invoiceNumber;
	private String dateOfInvoice;
	private String description;
	private String amount;
	private String status;
}
