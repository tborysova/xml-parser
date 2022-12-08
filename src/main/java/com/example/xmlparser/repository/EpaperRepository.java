package com.example.xmlparser.repository;

import com.example.xmlparser.entity.Epaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpaperRepository extends JpaRepository<Epaper, Long>, PagingAndSortingRepository<Epaper, Long> {

}
