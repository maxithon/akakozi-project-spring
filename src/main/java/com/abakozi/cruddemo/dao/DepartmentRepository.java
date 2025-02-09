package com.abakozi.cruddemo.dao;

import com.abakozi.cruddemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository  extends JpaRepository<Department, UUID> {
//you can add custom query methods fere if needed
}
