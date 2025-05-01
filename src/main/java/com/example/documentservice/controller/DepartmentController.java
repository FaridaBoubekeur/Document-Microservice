package com.example.documentservice.controller;

import com.example.documentservice.model.Department;
import com.example.documentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

 private final DepartmentService service;

 public DepartmentController(DepartmentService service) {
  this.service = service;
 }

 // 🟢 GET all departments (open to all for now)
 @GetMapping
 public ResponseEntity<List<Department>> getAll() {
  return ResponseEntity.ok(service.getAllDepartments());
 }

 // 🔐 ADMIN ONLY
 @PostMapping
 public ResponseEntity<Department> create(@RequestHeader("X-Role") String role,
   @RequestBody Department department) {
  if (!"ROLE_ADMIN".equals(role)) {
   return ResponseEntity.status(403).build();
  }
  return ResponseEntity.ok(service.createDepartment(department));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Department> update(@RequestHeader("X-Role") String role,
   @PathVariable Long id,
   @RequestBody Department department) {
  if (!"ROLE_ADMIN".equals(role)) {
   return ResponseEntity.status(403).build();
  }
  return ResponseEntity.ok(service.updateDepartment(id, department));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@RequestHeader("X-Role") String role,
   @PathVariable Long id) {
  if (!"ROLE_ADMIN".equals(role)) {
   return ResponseEntity.status(403).build();
  }
  service.deleteDepartment(id);
  return ResponseEntity.noContent().build();
 }
}
