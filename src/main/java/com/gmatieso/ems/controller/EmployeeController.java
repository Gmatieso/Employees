package com.gmatieso.ems.controller;

import com.gmatieso.ems.dto.EmployeeRequest;
import com.gmatieso.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return  employeeService.createEmployee(employeeRequest);

    }
}
