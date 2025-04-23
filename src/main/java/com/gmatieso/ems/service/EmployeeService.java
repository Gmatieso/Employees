package com.gmatieso.ems.service;

import com.gmatieso.ems.dto.EmployeeRequest;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity<?> createEmployee(EmployeeRequest employeeRequest);
    ResponseEntity<?> getAllEmployees();
    ResponseEntity<?> getEmployeeById(int id);
    ResponseEntity<?> updateEmployee(int id, EmployeeRequest employeeRequest);
    ResponseEntity<?> deleteEmployee(int id);
}
