package com.schoolofnet.helpdesk.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolofnet.helpdesk.model.Ticket;
import com.schoolofnet.helpdesk.service.TicketService;
import com.schoolofnet.helpdesk.util.TicketReportPdf;

@Controller
@RequestMapping("/reports")
public class ReportsController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/tickets")
	public String ticketsReports(@RequestParam(value="days", required=false) Integer days, Model model) {
		model.addAttribute("list", this.ticketService.ticketsByDays(days));
		return "reports/ticket";
	}
	
	@GetMapping("/tickets/pdfgen")
	public String ticketsReportsPdfGen(Model model) {
		return "reports/ticket_pdf";
	}
	
	@GetMapping(value="/tickets/pdf", produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> ticketsReportsPdf(@RequestParam(value="days", required=false) Integer days, Model model) {
		List<Ticket> tickets = this.ticketService.ticketsByDays(days);
		ByteArrayInputStream bais = TicketReportPdf.generate(tickets);
		return ResponseEntity
				.ok()
				.header("Content-Disposition", "inline; filename=report.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bais));
	}
}
