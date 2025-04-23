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

import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<?> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
       List<EmployeeResponse> employeeResponses = employees.stream().map(employee -> employeeMappers.employeeToEmployeeRespond(employee)).toList();
       return  ApiResponseEntity.success("Employees retrieved successfully", employeeResponses);
    }

    @Override
    public ResponseEntity<?> getEmployeeById(int id) {
        Employee employees = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found with id" + id));

         EmployeeResponse newEmployee = employeeMappers.employeeToEmployeeRespond(employees);

        return ApiResponseEntity.success("Employee retrieved successfully", newEmployee);
    }

    @Override
    public ResponseEntity<?> updateEmployee(int id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        // Update employee fields based on employeeRequest
        employee.setFirstName(employeeRequest.firstName());
        employee.setLastName(employeeRequest.lastName());
        employee.setEmail(employeeRequest.email());

        //save the updated employee
        Employee updatedEmployee = employeeRepository.save(employee);
        return ApiResponseEntity.success("Employees updated successfully", employeeMappers.employeeToEmployeeRespond(updatedEmployee));
    }

    @Override
    public ResponseEntity<?> deleteEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            return ApiResponseEntity.error("Employee not found with id: " + id, null);
        }
        employeeRepository.deleteById(id);
        return ApiResponseEntity.success("Employees deleted successfully", null);
    }
}
