package com.abakozi.cruddemo.dao;

import com.abakozi.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {


}
