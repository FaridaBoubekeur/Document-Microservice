
package com.example.documentservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Document {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String title;

 private Long categoryId;
 private Long departmentId;
 private Long createdByUserId;

 private LocalDateTime createdAt;

 // Getters and setters
 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public Long getCategoryId() {
  return categoryId;
 }

 public void setCategoryId(Long categoryId) {
  this.categoryId = categoryId;
 }

 public Long getDepartmentId() {
  return departmentId;
 }

 public void setDepartmentId(Long departmentId) {
  this.departmentId = departmentId;
 }

 public Long getCreatedByUserId() {
  return createdByUserId;
 }

 public void setCreatedByUserId(Long createdByUserId) {
  this.createdByUserId = createdByUserId;
 }

 public LocalDateTime getCreatedAt() {
  return createdAt;
 }

 public void setCreatedAt(LocalDateTime createdAt) {
  this.createdAt = createdAt;
 }
}
