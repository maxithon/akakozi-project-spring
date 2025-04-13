package com.abakozi.cruddemo.controller;

import com.abakozi.cruddemo.entity.Department;
import com.abakozi.cruddemo.entity.Employee;
import com.abakozi.cruddemo.service.DepartmentService;
import com.abakozi.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String ListEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "list-employees";
    }
    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        List<Department> departments = departmentService.findAll();
        model.addAttribute("employees",employee);
        model.addAttribute("departments",departments);
        return "employee-form";
    }

@PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employees") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees/list";
}
@GetMapping("/delete")
    public  String deleteEmployee(@RequestParam("employeeId") UUID id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
}
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") UUID theId, Model theModel){
               //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        //get all departments
        List<Department> departments = departmentService.findAll();
        //SET EMPLOYEE in the model to prepopulate the form
        theModel.addAttribute("employees", theEmployee);
        theModel.addAttribute("departments", departments);
        //send over to our form
        return "employee-form";
    }
}
