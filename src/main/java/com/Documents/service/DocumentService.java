package com.Documents.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Documents.entity.Document;
import com.Documents.repository.DocumentRepository;
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

    public Document getDocumentById(int id) {
        return documentRepository.findById(id).orElse(null);
    }

 
    public List<Document> getAllExportDocuments() {
        return documentRepository.findByType("export");
    }

    public List<Document> getAllImportDocuments() {
        return documentRepository.findByType("import");
    }

    public Document getBookById(int id) {
        return documentRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        documentRepository.deleteById(id);
    }
}
