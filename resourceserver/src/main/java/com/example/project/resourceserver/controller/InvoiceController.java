package com.example.project.resourceserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.project.resourceserver.model.Invoice;
import com.example.project.resourceserver.modelDTO.InvoiceDTO;
import com.example.project.resourceserver.service.InvoiceService;

@Controller
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@PreAuthorize("hashAnyRole('SUPERADMIN')")
	@RequestMapping(value = "/invoices", method = RequestMethod.GET)
	public List<Invoice> getListOfInvoice(){
		List<Invoice> listInvoice = invoiceService.getListOfInvoice();
		return listInvoice;
	}
	
	@PreAuthorize("hashAnyRole('SUPERADMIN', 'USER')")
	@RequestMapping(value = "invoices/{id}", method = RequestMethod.PUT)
	public ResponseEntity<InvoiceDTO> updateInvoice(@RequestBody InvoiceDTO invoiceDTO){
		
		InvoiceDTO invoice = invoiceService.updateInvoice(invoiceDTO);
		return new ResponseEntity<InvoiceDTO>(invoice, HttpStatus.OK);
	}
	
	@PreAuthorize("hashAnyRole('SUPERADMIN', 'USER')")
	@RequestMapping(value = "/invoices", method = RequestMethod.POST)
	public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO invoiceDTO){
		
		InvoiceDTO invoice = invoiceService.createInvoice(invoiceDTO);
		return new ResponseEntity<InvoiceDTO>(invoice, HttpStatus.OK);
	}
	
	@PreAuthorize("hashAnyRole('SUPERADMIN')")
	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteInvoice(@PathVariable("id") Long invoice_id){
		
		invoiceService.deleteInvoice(invoice_id);
		
	}
	
	@PreAuthorize("hashAnyRole('SUPERADMIN')")
	@RequestMapping(value = "/invoice/{id}")
	public void approveInvoice(@RequestBody Long id) {
		invoiceService.approveInvoice(id);
	}

}
