package com.abakozi.cruddemo.service;

import com.abakozi.cruddemo.entity.Department;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    List<Department> findAll();
    Department save(Department theDepartment);

    Department findById(UUID theId);

   void deleteById(UUID theId);
}
