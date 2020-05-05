package com.example.project.resourceserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.resourceserver.converters.InvoiceDTOToInvoice;
import com.example.project.resourceserver.converters.InvoiceToInvoiceDTO;
import com.example.project.resourceserver.exception.NotFoundException;
import com.example.project.resourceserver.model.Invoice;
import com.example.project.resourceserver.model.InvoiceStatus;
import com.example.project.resourceserver.modelDTO.InvoiceDTO;
import com.example.project.resourceserver.repository.InvoiceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

	private final InvoiceRepository invoiceRepository;
	private final InvoiceDTOToInvoice invoiceDTOToInvoice;
	private final InvoiceToInvoiceDTO invoiceToInvoiceDTO;

	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceDTOToInvoice invoiceDTOToInvoice,
			InvoiceToInvoiceDTO invoiceToInvoiceDTO) {
		this.invoiceRepository = invoiceRepository;
		this.invoiceDTOToInvoice = invoiceDTOToInvoice;
		this.invoiceToInvoiceDTO = invoiceToInvoiceDTO;
	}

	public List<Invoice> getListOfInvoice() {
		log.debug("I am in service");
		List<Invoice> invoiceList = new ArrayList<>();
		invoiceRepository.findAll().iterator().forEachRemaining(invoiceList::add);

		return invoiceList;
	}

	public Invoice findById(Long id) {
		Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
		if (!invoiceOptional.isPresent()) {
			throw new NotFoundException("Invoice Not Found! For ID value: " + id.toString());
		}
		return invoiceOptional.get();
	}

	@Transactional
	public InvoiceDTO createInvoice(InvoiceDTO invoiceDTO) {
		Invoice invoice = invoiceDTOToInvoice.convert(invoiceDTO);
		Invoice saveInvoice = invoiceRepository.save(invoice);
		log.debug("Saved Invoice: " + saveInvoice.getId());

		return invoiceToInvoiceDTO.convert(saveInvoice);
	}

	@Transactional
	public InvoiceDTO updateInvoice(InvoiceDTO invoiceDTO) {
		Invoice invoice = invoiceDTOToInvoice.convert(invoiceDTO);
		
		if (invoice.getStatus().equals("APPROVED")) {
			throw new NotFoundException("Cannot update already approved Invoice. For ID value: " + invoiceDTO.toString());
		}
		
		Invoice updateInvoice = invoiceRepository.save(invoice);
		
		return invoiceToInvoiceDTO.convert(updateInvoice);
	}

	@Transactional
	public void deleteInvoice(Long id) {
		Optional<Invoice> invoice = invoiceRepository.findById(id);

		if (invoice.get().getStatus().equals("APPROVED")) {
			throw new NotFoundException("Cannot delete already approved Invoice. For ID value: " + id.toString());
		}

		invoiceRepository.deleteById(id);
	}

	@Transactional
	public void approveInvoice(Long id) {
		Optional<Invoice> invoice = invoiceRepository.findById(id);
		Invoice in = invoice.get();
		in.setStatus(InvoiceStatus.APPROVED);
		invoiceRepository.save(in);
	}

}
