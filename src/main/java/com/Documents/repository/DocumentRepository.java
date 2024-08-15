 package com.Documents.repository;

 

 
 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Documents.entity.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document,Integer > {
     List<Document> findByType(String type);

}

