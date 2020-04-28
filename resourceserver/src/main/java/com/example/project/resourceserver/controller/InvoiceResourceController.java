package com.example.project.resourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.resourceserver.converter.AccessTokenMapper;
import com.example.project.resourceserver.model.Invoice;
import com.example.project.resourceserver.service.InvoiceResourceDAO;
import com.example.project.resourceserver.service.UserResourceDAO;

@RestController
public class InvoiceResourceController {
	
	@Autowired
	InvoiceResourceDAO invoiceResourceDAO;
	
	@Autowired
	UserResourceDAO userResourceDAO;
	
	@PreAuthorize("hashAnyRole('view_invoices', 'SUPERADMIN')")
	@RequestMapping(value = "/invoices", method = RequestMethod.GET)
	public ResponseEntity<Object> getListOfInvoice(){
		return new ResponseEntity<>(invoiceResourceDAO.getListOfInvoice(), HttpStatus.OK);
	}
	
	@PreAuthorize("hashAnyRole('delete_invoices', 'SUPERADMIN')")
	@RequestMapping(value = "invoices/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") String invoice_id){
		
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper) ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		
		if(accessTokenMapper.getUser_type().equalsIgnoreCase("admin") && userResourceDAO.isSupperAdmin(invoice_id)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		invoiceResourceDAO.deleteInvoice(invoice_id);
		return new ResponseEntity<>("Invoice deleted successfully", HttpStatus.OK);
		
	}
	
	@PreAuthorize("hashAnyRole('edit_invoices', 'SUPERADMIN')")
	@RequestMapping(value = "invoices/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateInvoice(@PathVariable("id") String invoice_id, @RequestBody Invoice invoice){
		
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper) ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		
		if(accessTokenMapper.getUser_type().equalsIgnoreCase("admin") && userResourceDAO.isSupperAdmin(invoice_id)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		invoiceResourceDAO.updateUser(invoice_id, invoice);
		return new ResponseEntity<>("Invoice updated successfully", HttpStatus.OK);
	}
	
	@PreAuthorize("hashAnyRole('create_invoices', 'SUPERADMIN')")
	@RequestMapping(value = "/invoices", method = RequestMethod.POST)
	public ResponseEntity<Object> createInvoice(@RequestBody Invoice invoice){
		
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper) ((OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getDecodedDetails();
		
		if(accessTokenMapper.getUser_type().equalsIgnoreCase("admin") && invoice.getUser_model().getUser_type().equalsIgnoreCase("super_admin")) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		invoiceResourceDAO.createInvoice(invoice);
		return new ResponseEntity<>("Invoice created successfully", HttpStatus.OK);
	}

}
