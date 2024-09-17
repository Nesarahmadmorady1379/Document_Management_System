package com.documentsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.documentsystem.entity.Document;


@Repository
public interface DocumentRepository extends JpaRepository<Document,Long > {
     List<Document> findByType(String type);

}
