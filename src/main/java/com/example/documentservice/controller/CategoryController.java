
package com.example.documentservice.controller;

import com.example.documentservice.model.Category;
import com.example.documentservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

 private final CategoryService service;

 public CategoryController(CategoryService service) {
  this.service = service;
 }

 // 🟢 GET all categories (open to all for now)
 @GetMapping
 public ResponseEntity<List<Category>> getAll() {
  return ResponseEntity.ok(service.getAllCategories());
 }

 // 🔐 ADMIN ONLY
 @PostMapping
 public ResponseEntity<Category> create(@RequestHeader("X-Role") String role,
   @RequestBody Category category) {
  if (!"ROLE_ADMIN".equals(role)) {
   return ResponseEntity.status(403).build();
  }
  return ResponseEntity.ok(service.createCategory(category));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Category> update(@RequestHeader("X-Role") String role,
   @PathVariable Long id,
   @RequestBody Category category) {
  if (!"ROLE_ADMIN".equals(role)) {
   return ResponseEntity.status(403).build();
  }
  return ResponseEntity.ok(service.updateCategory(id, category));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@RequestHeader("X-Role") String role,
   @PathVariable Long id) {
  if (!"ROLE_ADMIN".equals(role)) {
   return ResponseEntity.status(403).build();
  }
  service.deleteCategory(id);
  return ResponseEntity.noContent().build();
 }
}
