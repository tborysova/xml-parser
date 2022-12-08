package com.example.xmlparser.service;

import com.example.xmlparser.dto.EpaperRequestDto;
import com.example.xmlparser.entity.Epaper;
import com.example.xmlparser.mapper.EpaperMapper;
import com.example.xmlparser.repository.EpaperRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

@Service
public class EpaperServiceImpl implements EpaperService {

    @Autowired
    EpaperRepository repository;

    @Autowired
    private EpaperMapper mapper;

    @Override
    public ResponseEntity<?> uploadXml(MultipartFile file) throws JAXBException, SAXException, IOException {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        JAXBContext context = JAXBContext.newInstance(EpaperRequestDto.class);
        Unmarshaller un = context.createUnmarshaller();
        URL url = getClass().getClassLoader().getResource("epaperRequest.xsd");
        Schema schema = sf.newSchema(url);
        un.setSchema(schema);

        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(file.getInputStream()));

        EpaperRequestDto epaperRequest = (EpaperRequestDto) un.unmarshal(file.getInputStream());
        Epaper epaper = mapper.toEntity(epaperRequest, file.getOriginalFilename());

        epaper = repository.save(epaper);
        return ResponseEntity.ok(epaper);
    }

    @Override
    public Page<Epaper> findAllEpaperRequests(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
