package com.gmatieso.ems.controller;

import com.gmatieso.ems.dto.EmployeeRequest;
import com.gmatieso.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest){
        return employeeService.updateEmployee(id, employeeRequest);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }
}
