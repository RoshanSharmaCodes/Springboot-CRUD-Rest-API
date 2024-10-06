package com.crudapi.crudapi;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmpService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        // employees.add(employee);
        return "Employee Created Successfully";
    }

    @Override
    public boolean deleteEmployee(Long employeeId) {
        employees.remove(employeeId);
        return true;
    }

    @Override
    public List<Employee> readEmployee() {
        return employees;
    }

}
