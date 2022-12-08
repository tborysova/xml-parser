package com.example.xmlparser.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "epaper")
@Setter
@Getter
public class Epaper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String fileName;

    @Column
    private String newspaperName;

    @Column
    private Long width;

    @Column
    private Long height;

    @Column
    private Long dpi;

    @Column
    private LocalDateTime uploadTime;

}
