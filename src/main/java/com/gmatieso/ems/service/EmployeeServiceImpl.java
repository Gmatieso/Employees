package com.gmatieso.ems.service;

import com.gmatieso.ems.dto.EmployeeRequest;
import com.gmatieso.ems.dto.EmployeeResponse;
import com.gmatieso.ems.entity.Employee;
import com.gmatieso.ems.mapper.EmployeeMappers;
import com.gmatieso.ems.repository.EmployeeRepository;
import com.gmatieso.ems.response.ApiResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    private EmployeeMappers employeeMappers;

    //
    @Override
    public ResponseEntity<?> createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMappers.employeeRequestToEmployee(employeeRequest);
        Employee savedEmployee =  employeeRepository.save(employee);
        EmployeeResponse  newEmployee =  employeeMappers.employeeToEmployeeRespond(savedEmployee);
        return ApiResponseEntity.success("Employee created successfully", newEmployee);
    }
}
