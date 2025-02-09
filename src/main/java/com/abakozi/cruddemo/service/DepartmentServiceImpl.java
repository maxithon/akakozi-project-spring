package com.abakozi.cruddemo.service;

import com.abakozi.cruddemo.dao.DepartmentRepository;
import com.abakozi.cruddemo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository theDepartmentRepository){
        departmentRepository=theDepartmentRepository;
    }
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
    @Override
    public Department save(Department theDepartment) {
        return departmentRepository.save(theDepartment);
    }

@Override
public Department findById(UUID theId) {
    Optional<Department> result = departmentRepository.findById(theId);
        Department theDepartment = null;
        if(result.isPresent()){
            theDepartment = result.get();
        }else{
            //we didn't find the department
            throw new RuntimeException("Did not find department id - " + theId);
        }
        return theDepartment;
    }


    @Override
    public void deleteById(UUID theId) {departmentRepository.deleteById(theId);}
}
