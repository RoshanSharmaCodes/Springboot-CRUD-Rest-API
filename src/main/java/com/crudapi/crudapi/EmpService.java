package com.crudapi.crudapi;

import java.util.*;

public interface EmpService {
    String createEmployee(Employee employee);
    boolean deleteEmployee(Long employeeId);
    List<Employee> readEmployee();
}
