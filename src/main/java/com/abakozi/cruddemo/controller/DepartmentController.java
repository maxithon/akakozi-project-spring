package com.abakozi.cruddemo.controller;

import com.abakozi.cruddemo.entity.Department;
import com.abakozi.cruddemo.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
//define field for employee service
    private DepartmentService departmentService;
    //constructor injection
    public DepartmentController(DepartmentService theDepartmentService){
        departmentService = theDepartmentService;
    }
    //add mapping for "list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){
      //get the employee from db
      List<Department> theDepartments=departmentService.findAll();
      //add to the spring model
        theModel.addAttribute("departments", theDepartments);
        return "list-departments";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute to bind form data
        Department theDepartment = new Department();
        theModel.addAttribute("departments", theDepartment);
        return "department-form";
    }
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("departments") Department theDepartment){
  //save the department
  departmentService.save(theDepartment);
  //use a redirect to prevent duplicate submissions
        return "redirect:/departments/list";
    }
 @GetMapping("/showFormForUpdate")
 public String showFormForUpdate(@RequestParam("departmentId") UUID theId, Model theModel){
        //get the department from the service
     Department theDepartment = departmentService.findById(theId);
     //SET DEPARTMENT in the model to prepopulate the form
     theModel.addAttribute("departments", theDepartment);
     //send over to our form
     return "department-form";
 }
 //controller for delete
    @GetMapping("/delete")
    public String delete(@RequestParam("departmentId") UUID theId){
        //delete the employee
        departmentService.deleteById(theId);
        //redirect to the /employee/list
        return "redirect:/departments/list";
    }
}
