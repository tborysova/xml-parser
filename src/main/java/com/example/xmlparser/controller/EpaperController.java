package com.example.xmlparser.controller;

import com.example.xmlparser.entity.Epaper;
import com.example.xmlparser.service.EpaperService;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

@RestController
@RequestMapping("/api/epapers")
public class EpaperController {

    @Autowired
    private EpaperService epaperService;

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("fileName") MultipartFile file)
            throws JAXBException, IOException, SAXException {
        return epaperService.uploadXml(file);
    }

    @GetMapping
    public Page<Epaper> findAllEpaperRequests(Pageable pageable) {
        return epaperService.findAllEpaperRequests(pageable);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleParseException(SAXException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
