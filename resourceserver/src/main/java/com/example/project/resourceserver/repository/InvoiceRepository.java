package com.example.project.resourceserver.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.project.resourceserver.model.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
	
	/*
	 * @Query("SELECT * FROM  invoices") List<Invoice> findById();
	 */
	/*
	 * @Query("SELECT * FROM invoices WHERE id=:id") Optional<Invoice>
	 * findById(@Param("id") Long id);
	 * 
	 * 
	 * @Query("INSERT INTO invoices (amount, date_of_invoice, description, invoice_number, status) VALUES (?,?,?,?,?"
	 * ) Invoice saveInvoice(Invoice invoice);
	 * 
	 * @Query("SELECT * FROM invoices WHERE id=:id") Invoice
	 * getListOfInvoice(@Param("id") int id);
	 * 
	 * @Query("UPDATE invoices SET amount=:amount, date_of_invoice=:date_of_invoice, description=:description, invoice_number=:invoice_number, status=:status where id=:id"
	 * ) Invoice updateInvoice();
	 * 
	 * @Query("DELET FROM invoices WHERE id=:id") void deleteById(@Param("id") Long
	 * id);
	 */
}
