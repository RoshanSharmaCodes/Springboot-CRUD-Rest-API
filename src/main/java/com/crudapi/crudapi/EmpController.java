package com.crudapi.crudapi;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController

public class EmpController {
    EmpService employeeService = new EmployeeServiceImpl();
    //Dependency Injection
    // @Autowired
    // EmpService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployee();
    }

    @GetMapping("employees/{id}")
    public Employee getMethodName(@PathVariable Long id) {
        return employeeService.readSingleEmployee(id);
    }
    

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        // employeeService.createEmployee(employee);
        return "Saved Successfully!";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id)){
            return "Deleted Successfully!";
        }
        return "Deletion Failed!";
    }

    @PutMapping("path/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "Record Updated Successfully!";
    }
}