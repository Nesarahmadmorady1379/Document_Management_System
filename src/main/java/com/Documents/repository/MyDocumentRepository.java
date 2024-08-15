package com.Documents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Documents.entity.MyDocumentList;
@Repository
public interface MyDocumentRepository extends JpaRepository<MyDocumentList,Integer>{

}
