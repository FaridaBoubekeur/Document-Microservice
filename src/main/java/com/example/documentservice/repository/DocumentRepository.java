// src/main/java/com/example/documentservice/repository/DocumentRepository.java

package com.example.documentservice.repository;

import com.example.documentservice.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
 List<Document> findByDepartmentId(Long departmentId);

 List<Document> findByTitleContainingIgnoreCase(String title);

 List<Document> findByDepartmentIdIn(List<Long> departmentIds);
}
