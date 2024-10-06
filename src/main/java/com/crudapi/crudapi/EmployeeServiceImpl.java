package com.crudapi.crudapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;
    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Employee Created Successfully";
    }

    @Override
    public boolean deleteEmployee(Long employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public List<Employee> readEmployee() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmployeeEntity employeEntity: employeeList){
            Employee emp = new Employee();
            emp.setName(employeEntity.getName());
            emp.setEmail(employeEntity.getEmail());
            emp.setId(employeEntity.getId());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public String updateEmployee(Long employeeId, Employee employee) {
        EmployeeEntity foundEmployee = employeeRepository.findById(employeeId).get();
        foundEmployee.setName(employee.getName());
        foundEmployee.setEmail(employee.getEmail());
        employeeRepository.save(foundEmployee);
        return "Record Updated Successfully";
    }

    @Override
    public Employee readSingleEmployee(Long id) {
       EmployeeEntity foundEmployee = employeeRepository.findById(id).get();
       Employee employee = new Employee();
       BeanUtils.copyProperties(foundEmployee, employee);
       return employee;
    }

}
