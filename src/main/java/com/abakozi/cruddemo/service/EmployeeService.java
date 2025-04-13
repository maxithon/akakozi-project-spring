package com.abakozi.cruddemo.service;

import com.abakozi.cruddemo.entity.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(UUID id);
    Employee save(Employee employee);
    void deleteById(UUID id);
}
