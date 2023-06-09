package com.smthasa.myfancypdfinvoices.springboot.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smthasa.myfancypdfinvoices.springboot.dto.InvoiceDto;
import com.smthasa.myfancypdfinvoices.springboot.model.Invoice;
import com.smthasa.myfancypdfinvoices.springboot.service.InvoiceService;

import jakarta.validation.Valid;

@RestController
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
