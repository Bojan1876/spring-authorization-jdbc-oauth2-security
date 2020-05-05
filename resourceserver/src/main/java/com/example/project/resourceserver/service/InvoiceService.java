package com.example.project.resourceserver.service;

import java.util.List;

import com.example.project.resourceserver.model.Invoice;
import com.example.project.resourceserver.modelDTO.InvoiceDTO;

public interface InvoiceService {

	List<Invoice> getListOfInvoice();
	
	Invoice findById(Long id);
	
	InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);
	
	InvoiceDTO updateInvoice(InvoiceDTO invoiceDTO);
	
	void deleteInvoice(Long id);
	
	void approveInvoice(Long id);
}
