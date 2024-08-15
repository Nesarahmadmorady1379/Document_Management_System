package com.Documents.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import com.Documents.entity.Document;
import com.Documents.service.DocumentService;

import java.util.List;

@Controller
public class DocumentControlar {
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
public String addDocument(@ModelAttribute Document b) {
    if (b.getType() == null || b.getType().isEmpty()) {
        // Handle the case where type is null or empty
        return "redirect:/error"; // Or return an appropriate error view
    }

     documentService.save(b);

    if ("export".equalsIgnoreCase(b.getType())) {
        return "redirect:/export_documents";
    } else if ("import".equalsIgnoreCase(b.getType())) {
        return "redirect:/import_documents";
    }

    return "redirect:/error"; // Handle the case where type is neither export nor import
}
   

    // @GetMapping("/download/{id}")
    // public ResponseEntity<byte[]> downloadFile(@PathVariable("id") int id) {
    //     try {
    //         Document document = documentService.getBookById(id);
    //         if (document == null) {
    //             return ResponseEntity.notFound().build();
    //         }

    //         HttpHeaders headers = new HttpHeaders();
    //         headers.setContentType(MediaType.parseMediaType(document.getFileType()));
    //         headers.setContentDisposition(ContentDisposition.builder("attachment")
    //                 .filename(document.getFileName())
    //                 .build());

    //         return new ResponseEntity<>(document.getFileData(), headers, HttpStatus.OK);

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }

    // @RequestMapping("/editDocument/{id}")
    // public String editDocument(@PathVariable("id") int id, Model model) {
    //     Document document = documentService.getBookById(id);
    //     model.addAttribute("document", document);
    //     return "DocumentEdit";
    // }

    // @RequestMapping("/deleteDocument/{id}")
    // public String deleteDocument(@PathVariable("id") int id) {
    //     documentService.deleteById(id);
    //     return "redirect:/import_documents"; // or redirect to another appropriate page
    // }

    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(IllegalArgumentException.class)
        public String handleIllegalArgumentException(IllegalArgumentException ex) {
            return "error";
        }
    }
}
