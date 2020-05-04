package com.example.project.resourceserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.resourceserver.model.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
	
}
