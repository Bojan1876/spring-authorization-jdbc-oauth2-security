package com.example.project.resourceserver.service;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.project.resourceserver.model.Invoice;

@Repository
public interface InvoiceService extends CrudRepository<Invoice, Long>{
	/*
	 * @Query("SELECT * FROM  invoices") String getInvoice();
	 * 
	 * //@
	 * Query("INSERT INTO invoices (amount, date_of_invoice, description, invoice_number, status) VALUES (?,?,?,?,?"
	 * ) //Invoice saveInvoice(Invoice invoice);
	 * 
	 * @Query("SELECT * FROM invoices WHERE id=:id") Invoice getListOfInvoice(int
	 * id);
	 * 
	 * @Query("UPDATE invoices SET amount=:amount, date_of_invoice=:date_of_invoice, description=:description, invoice_number=:invoice_number, status=:status where id=:id"
	 * ) String updateInvoice();
	 * 
	 * @Query("DELET FROM invoices WHERE id=:id") String deleteById(String id);
	 */
}
