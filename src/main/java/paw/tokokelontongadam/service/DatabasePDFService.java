/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paw.tokokelontongadam.service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import paw.tokokelontongadam.entity.Transaksi;

@Service
public class DatabasePDFService {

    public static ByteArrayInputStream transaksiPDFReport(List<Transaksi> transaksis) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Laporan Penjualan", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);

            // Add PDF Table Header ->
            Stream.of("ID", "Nama Produk", "Harga", "Jumlah Beli", "Total Harga", "Tanggal Transaksi")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                        header.setBackgroundColor(Color.cyan);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        // header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, headFont));
                        table.addCell(header);
                    });
            for (Transaksi transaksi : transaksis) {
                
                String idAsString = String.valueOf(transaksi.getId());
                
                PdfPCell idCell = new PdfPCell(new Phrase(idAsString));
                idCell.setPaddingLeft(6);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);
                PdfPCell nameCell = new PdfPCell(new Phrase(transaksi.getNamaProduk()));
                nameCell.setPaddingLeft(6);
                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(nameCell);
                PdfPCell hargaCell = new PdfPCell(new Phrase(String.valueOf(transaksi.getHarga())));
                hargaCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                hargaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                hargaCell.setPaddingRight(6);
                table.addCell(hargaCell);
                PdfPCell jmlBeliCell = new PdfPCell(new Phrase(String.valueOf(transaksi.getJumlahBeli())));
                jmlBeliCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                jmlBeliCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                jmlBeliCell.setPaddingRight(6);
                table.addCell(jmlBeliCell);
                PdfPCell totalHargaCell = new PdfPCell(new Phrase(String.valueOf(transaksi.getTotalHarga())));
                totalHargaCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                totalHargaCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                totalHargaCell.setPaddingRight(6);
                table.addCell(totalHargaCell);
                PdfPCell tglTransaksiCell = new PdfPCell(new Phrase(String.valueOf(transaksi.getTglTransaksi())));
                tglTransaksiCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tglTransaksiCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tglTransaksiCell.setPaddingRight(6);
                table.addCell(tglTransaksiCell);
            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}

