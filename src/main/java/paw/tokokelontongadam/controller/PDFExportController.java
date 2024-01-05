/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paw.tokokelontongadam.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import paw.tokokelontongadam.entity.Transaksi;
import paw.tokokelontongadam.repo.TransaksiRepository;
import paw.tokokelontongadam.service.DatabasePDFService;

@Controller
public class PDFExportController {

    @Autowired
    TransaksiRepository transaksiRepo;

    @GetMapping(value = "/openpdf/transaksi", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> transaksiReport() throws IOException {
        List<Transaksi> exams = (List<Transaksi>) transaksiRepo.findAll();
        ByteArrayInputStream bis = DatabasePDFService.transaksiPDFReport(exams);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = exam.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
