package com.schoolofnet.helpdesk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.schoolofnet.helpdesk.model.Ticket;

public class TicketReportPdf {

	public static ByteArrayInputStream generate(List<Ticket> tickets) {
		Document doc = new Document();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 try {
			 PdfPTable table = new PdfPTable(3);
			 table.setWidthPercentage(100);
			 table.setWidths(new int[] {1, 2, 6});
			 
			 PdfPCell headerCell;
			 
			 headerCell = new PdfPCell(new Phrase("ID"));
			 headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			 table.addCell(headerCell);
			 
			 headerCell = new PdfPCell(new Phrase("NAME"));
			 headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			 table.addCell(headerCell);
			 
			 headerCell = new PdfPCell(new Phrase("DESCRIPTION"));
			 headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			 table.addCell(headerCell);
			 
			 tickets.forEach(ticket->{
				 PdfPCell bodyCell;
				 
				 bodyCell = new PdfPCell(new Phrase(ticket.getId().toString()));
				 bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 table.addCell(bodyCell);
				 
				 bodyCell = new PdfPCell(new Phrase(ticket.getName()));
				 bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 table.addCell(bodyCell);
				 
				 bodyCell = new PdfPCell(new Phrase(ticket.getDescription()));
				 bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				 table.addCell(bodyCell);
			 });
			 
			 PdfWriter.getInstance(doc, baos);
			 doc.open();
			 
			 Paragraph title = new Paragraph(new Phrase("Tickets by days"));
			 title.setAlignment(Element.ALIGN_CENTER);
			 title.setSpacingAfter(10);
			 
			 doc.add(title);
			 doc.add(table);
			 
			 doc.close();
		 } catch (Exception ex) {
			 ex.printStackTrace();
		 }
		 
		 return new ByteArrayInputStream(baos.toByteArray());
	}
}
