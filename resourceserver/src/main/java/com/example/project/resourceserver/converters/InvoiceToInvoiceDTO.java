package com.example.project.resourceserver.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.project.resourceserver.model.Invoice;
import com.example.project.resourceserver.modelDTO.InvoiceDTO;

import lombok.Synchronized;

@Component
public class InvoiceToInvoiceDTO implements Converter<Invoice, InvoiceDTO>{

	@Synchronized
	@Nullable
	@Override
	public InvoiceDTO convert(Invoice source) {
		if(source == null) {
			return null;
		}
		final InvoiceDTO invoiceDTO = new InvoiceDTO();
		invoiceDTO.setId(source.getId());
		invoiceDTO.setInvoiceNumber(source.getInvoiceNumber());
		invoiceDTO.setDateOfInvoice(source.getDateOfInvoice());
		invoiceDTO.setDescription(source.getDescription());
		invoiceDTO.setAmount(source.getAmount());
		invoiceDTO.setStatus(source.getStatus());
		return invoiceDTO;
	}

}
