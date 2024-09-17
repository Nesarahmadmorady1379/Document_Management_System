package com.documentsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Document {
    
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String sender;
    private String receiver;
    private String sendedDate;
    private String registerNumber;
    private String registerDate;
    private String aboutDocument;
    private String serialNumber;
	@Column(length = 512,nullable = false,unique =true)
    private String name;
	private Long size;
	@Column(name = "content", columnDefinition = "LONGBLOB")
	private byte[]content;

  

    public Document() {
    }

    public Document(long id, String type, String sender, String receiver, String sendedDate, String registerNumber,
                String registerDate, String aboutDocument, String serialNumber, byte[] content, String name, Long size) {
    this.id = id;
    this.type = type;
    this.sender = sender;
    this.receiver = receiver;
    this.sendedDate = sendedDate;
    this.registerNumber = registerNumber;
    this.registerDate = registerDate;
    this.aboutDocument = aboutDocument;
    this.serialNumber = serialNumber;
    this.name = name;
    this.size = size;
    this.content = content;
}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public long getId() {
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
	}}
