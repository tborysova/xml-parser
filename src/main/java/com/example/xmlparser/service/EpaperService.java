package com.example.xmlparser.service;

import com.example.xmlparser.entity.Epaper;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

public interface EpaperService {

    ResponseEntity<?> uploadXml(MultipartFile file) throws JAXBException, SAXException, IOException;

    Page<Epaper> findAllEpaperRequests(Pageable pageable);

}
