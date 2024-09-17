package com.documentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.documentsystem.entity.Document;
import com.documentsystem.service.DocumentService;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/document_register")
    public String documentRegister() {
        return "DocumentRegister";
    }

    @GetMapping("/import_documents")
    public ModelAndView getAllImportDocuments() {
        List<Document> list = documentService.getAllImportDocuments();
        return new ModelAndView("import_documents", "documents", list);
    }

    @GetMapping("/export_documents")
    public ModelAndView getAllExportDocuments() {
        List<Document> list = documentService.getAllExportDocuments();
        return new ModelAndView("export_documents", "documents", list);
    }

    @PostMapping("/save")
    public String addDocument(@ModelAttribute Document document, @RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                document.setName(file.getOriginalFilename());
                document.setSize(file.getSize());
                document.setContent(file.getBytes());
            }
            documentService.save(document);

            if ("export".equalsIgnoreCase(document.getType())) {
                return "redirect:/export_documents";
            } else if ("import".equalsIgnoreCase(document.getType())) {
                return "redirect:/import_documents";
            }

            return "redirect:/error"; 
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error"; 
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);

        if (document != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(document.getName()).build());
            headers.setContentLength(document.getSize());

            return new ResponseEntity<>(document.getContent(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @GetMapping("/editDocument/{id}")
    public ModelAndView editDocument(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            return new ModelAndView("DocumentEdit", "document", document);
        } else {
            return new ModelAndView("error"); 
        }
    }

    @PostMapping("/updateDocument")
    public String updateDocument(@ModelAttribute Document document, @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                document.setName(file.getOriginalFilename());
                document.setSize(file.getSize());
                document.setContent(file.getBytes());
            }
            documentService.updateDocument(document.getId(), document);

            if ("export".equalsIgnoreCase(document.getType())) {
                return "redirect:/export_documents";
            } else if ("import".equalsIgnoreCase(document.getType())) {
                return "redirect:/import_documents";
            }

            return "redirect:/error"; 
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error"; 
        }
    }

    @GetMapping("/deleteDocument/{id}")
    public String deleteDocument(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            String docType = document.getType();
            documentService.deleteById(id);

            if ("export".equalsIgnoreCase(docType)) {
                return "redirect:/export_documents";
            } else if ("import".equalsIgnoreCase(docType)) {
                return "redirect:/import_documents";
            }
        }
        return "redirect:/home"; 
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(IllegalArgumentException.class)
        public String handleIllegalArgumentException(IllegalArgumentException ex) {
            return "error";
        }
    }
}
