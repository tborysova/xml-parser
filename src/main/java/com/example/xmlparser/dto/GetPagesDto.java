package com.example.xmlparser.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import lombok.Data;

@Data
@XmlRootElement(name = "getPages")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetPagesDto {

    @XmlAttribute
    private Long editionDefId;

    @XmlAttribute
    private Date publicationDate;
}
