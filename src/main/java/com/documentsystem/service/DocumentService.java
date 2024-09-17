package com.documentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.documentsystem.entity.Document;
import com.documentsystem.repository.DocumentRepository;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public void save(Document document) {
        try {
            documentRepository.save(document);
        } catch (Exception e) {
            throw new RuntimeException("Error saving document", e);
        }
    }

    public List<Document> getAllDocumentsByType(String type) {
        return documentRepository.findByType(type);
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public List<Document> getAllExportDocuments() {
        return documentRepository.findByType("export");
    }

    public List<Document> getAllImportDocuments() {
        return documentRepository.findByType("import");
    }

    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }

    public void updateDocument(Long id, Document updatedDocument) {
        Document existingDocument = documentRepository.findById(id).orElse(null);
        if (existingDocument != null) {
            existingDocument.setType(updatedDocument.getType());
            existingDocument.setSender(updatedDocument.getSender());
            existingDocument.setReceiver(updatedDocument.getReceiver());
            existingDocument.setRegisterDate(updatedDocument.getRegisterDate());
            existingDocument.setSendedDate(updatedDocument.getSendedDate());
            existingDocument.setAboutDocument(updatedDocument.getAboutDocument());
    
            if (updatedDocument.getContent() != null) {
                existingDocument.setContent(updatedDocument.getContent());
                existingDocument.setSize(updatedDocument.getSize());
                existingDocument.setName(updatedDocument.getName());
            }
    
            documentRepository.save(existingDocument);
        } else {
            throw new RuntimeException("Document not found");
        }
    }
}

