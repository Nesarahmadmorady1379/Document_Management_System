package com.Documents.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String sender;
    private String receiver;
    private String sendedDate;
    private String registerNumber;
    private String registerDate;
    private String aboutDocument;
    private String serialNumber;
    
  // To store the file type

    public Document() {
    }

    public Document(int id, String type, String sender, String receiver, String sendedDate, String registerNumber,
                    String registerDate, String aboutDocument, String serialNumber, byte[] fileData, String fileName, String fileType) {
        this.id = id;
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.sendedDate = sendedDate;
        this.registerNumber = registerNumber;
        this.registerDate = registerDate;
        this.aboutDocument = aboutDocument;
        this.serialNumber = serialNumber;
       
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSendedDate() {
		return sendedDate;
	}

	public void setSendedDate(String sendedDate) {
		this.sendedDate = sendedDate;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getAboutDocument() {
		return aboutDocument;
	}

	public void setAboutDocument(String aboutDocument) {
		this.aboutDocument = aboutDocument;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	

 
}
