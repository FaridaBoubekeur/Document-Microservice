
package com.example.documentservice.service;

import com.example.documentservice.model.Department;
import com.example.documentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

 private final DepartmentRepository repository;

 public DepartmentService(DepartmentRepository repository) {
  this.repository = repository;
 }

 public Department createDepartment(Department department) {
  return repository.save(department);
 }

 public Department updateDepartment(Long id, Department updatedDepartment) {
  Department department = repository.findById(id)
    .orElseThrow(() -> new RuntimeException("Department not found"));
  department.setName(updatedDepartment.getName());
  return repository.save(department);
 }

 public void deleteDepartment(Long id) {
  repository.deleteById(id);
 }

 public List<Department> getAllDepartments() {
  return repository.findAll();
 }
}
