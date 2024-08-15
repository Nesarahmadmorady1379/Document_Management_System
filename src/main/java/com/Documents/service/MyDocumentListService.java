package com.Documents.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Documents.entity.MyDocumentList;
import com.Documents.repository.MyDocumentRepository;

@Service
public class MyDocumentListService {
     
	 @Autowired
	 private MyDocumentRepository mybook;
	public void saveMyBook(MyDocumentList book) {
		mybook.save(book);
	}
	public List<MyDocumentList> getAllMyBooks(){
		return mybook.findAll();
	}
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
