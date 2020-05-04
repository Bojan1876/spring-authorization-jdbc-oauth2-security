package com.example.project.resourceserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project.resourceserver.model.Invoice;
import com.example.project.resourceserver.repository.InvoiceRepository;

@Repository
public class InvoiceResourceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	InvoiceRepository invoiceRepository;

	public List<Invoice> getListOfInvoice() {
		
		/*
		 * Collection<Map<String, Object>> rows =
		 * jdbcTemplate.queryForList("select * from invoices"); List<Invoice>
		 * invoiceList = new ArrayList<>(); rows.stream().map((row) -> { Invoice invoice
		 * = new Invoice(); invoice.setAmount((String) row.get("amount"));
		 * invoice.setDateOfInvoice((String) row.get("date_of_invoice"));
		 * invoice.setDescription((String) row.get("description")); invoice.setId((Long)
		 * row.get("id"));
		 * invoice.setInvoiceNumber(String.valueOf(row.get("invoice_number")));
		 * invoice.setStatus((Status) row.get("status")); return invoice;
		 * }).forEach((ss3) -> { invoiceList.add(ss3); });
		 */
		
		return (List<Invoice>) invoiceRepository.findAll();
	}
	
	public void deleteInvoice(Long id) {
		invoiceRepository.deleteById(id);
	}

	public void updateInvoice(String invoice_id, Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	public void createInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	/*
	 * public void deleteInvoice(String invoice_id) {
	 * jdbcTemplate.update("delete from invoices where id=?", new Object[] {
	 * invoice_id }); }
	 * 
	 * public void updateInvoice(String invoice_id, Invoice invoice) {
	 * jdbcTemplate.update(
	 * "update invoices set amount=?, date_of_invoice=?, description=?, invoice_number=?, status=? where id=?"
	 * , new Object[] { invoice.getAmount(), invoice.getDateOfInvoice(),
	 * invoice.getDescription(), invoice.getInvoiceNumber(), invoice.getStatus(),
	 * invoice_id });
	 * 
	 * }
	 * 
	 * public void createInvoice(Invoice invoice) { jdbcTemplate.update(
	 * "insert into invoices (amount, date_of_invoice, description, invoice_number, status) values "
	 * + "(?,?,?,?,?)", new Object[] { invoice.getAmount(),
	 * invoice.getDateOfInvoice(), invoice.getDescription(),
	 * invoice.getInvoiceNumber(), invoice.getStatus() }); }
	 */
	

}
