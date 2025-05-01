
package com.example.documentservice.service;

import com.example.documentservice.model.Category;
import com.example.documentservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

 private final CategoryRepository repository;

 public CategoryService(CategoryRepository repository) {
  this.repository = repository;
 }

 public Category createCategory(Category category) {
  return repository.save(category);
 }

 public Category updateCategory(Long id, Category updatedCategory) {
  Category category = repository.findById(id)
    .orElseThrow(() -> new RuntimeException("Category not found"));
  category.setName(updatedCategory.getName());
  return repository.save(category);
 }

 public void deleteCategory(Long id) {
  repository.deleteById(id);
 }

 public List<Category> getAllCategories() {
  return repository.findAll();
 }
}
