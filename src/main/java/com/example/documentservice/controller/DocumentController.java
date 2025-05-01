// src/main/java/com/example/documentservice/controller/DocumentController.java

package com.example.documentservice.controller;

import com.example.documentservice.model.Document;
import com.example.documentservice.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

 private final DocumentService service;

 public DocumentController(DocumentService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<Document> create(@RequestBody Document document) {
  return ResponseEntity.ok(service.createDocument(document));
 }

 @GetMapping
 public ResponseEntity<List<Document>> getAll(
   @RequestHeader(value = "X-Role", required = false) String role,
   @RequestHeader(value = "X-Departments", required = false) String deptHeader) {
  if ("ROLE_ADMIN".equals(role)) {
   return ResponseEntity.ok(service.getAllDocuments());
  }

  if ("ROLE_USER".equals(role) && deptHeader != null) {
   List<Long> deptIds = Arrays.stream(deptHeader.split(","))
     .map(String::trim)
     .map(Long::parseLong)
     .collect(Collectors.toList());

   return ResponseEntity.ok(service.getDocumentsForUser(deptIds));
  }

  return ResponseEntity.status(403).build();
 }

 @GetMapping("/search")
 public ResponseEntity<List<Document>> search(@RequestParam String title) {
  return ResponseEntity.ok(service.searchByTitle(title));
 }

 @GetMapping("/by-department/{id}")
 public ResponseEntity<List<Document>> byDepartment(@PathVariable Long id) {
  return ResponseEntity.ok(service.getDocumentsByDepartment(id));
 }
}
