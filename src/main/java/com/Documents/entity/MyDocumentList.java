package com.Documents.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MyDocumentList {
	@Id
	private int id;
	private String name;
	private String author;
	private int Publication_year;
	private String price;
	public MyDocumentList(int id, String name, String author,int Publication_year, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.Publication_year=Publication_year;
		this.price = price;
	}
	public MyDocumentList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPublication_year() {
		return Publication_year;
	}
	public void setPublication_year(int publication_year) {
		 this.Publication_year = publication_year;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
