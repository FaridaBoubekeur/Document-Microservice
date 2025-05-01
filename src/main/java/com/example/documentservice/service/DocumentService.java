// src/main/java/com/example/documentservice/service/DocumentService.java

package com.example.documentservice.service;

import com.example.documentservice.model.Document;
import com.example.documentservice.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocumentService {

 private final DocumentRepository repository;

 public DocumentService(DocumentRepository repository) {
  this.repository = repository;
 }

 public Document createDocument(Document document) {
  document.setCreatedAt(LocalDateTime.now());
  return repository.save(document);
 }

 public List<Document> getDocumentsByDepartment(Long deptId) {
  return repository.findByDepartmentId(deptId);
 }

 public List<Document> searchByTitle(String title) {
  return repository.findByTitleContainingIgnoreCase(title);
 }

 public List<Document> getAllDocuments() {
  return repository.findAll();
 }

 public List<Document> getDocumentsForUser(List<Long> departmentIds) {
  return repository.findByDepartmentIdIn(departmentIds);
 }
}
