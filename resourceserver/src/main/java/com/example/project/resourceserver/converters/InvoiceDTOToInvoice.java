package com.example.project.resourceserver.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.project.resourceserver.model.Invoice;
import com.example.project.resourceserver.modelDTO.InvoiceDTO;

import lombok.Synchronized;

@Component
public class InvoiceDTOToInvoice implements Converter<InvoiceDTO, Invoice>{

	@Synchronized
	@Nullable
	@Override
	public Invoice convert(InvoiceDTO source) {
		if (source == null) {
			return null;
		}
		
		final Invoice invoice = new Invoice();
		invoice.setId(source.getId());
		invoice.setInvoiceNumber(source.getInvoiceNumber());
		invoice.setDateOfInvoice(source.getDateOfInvoice());
		invoice.setDescription(source.getDescription());
		invoice.setAmount(source.getAmount());
		invoice.setStatus(source.getStatus());
		return invoice;
	}

}
