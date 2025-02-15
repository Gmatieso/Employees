package com.gmatieso.ems.mapper;

import com.gmatieso.ems.dto.EmployeeDtoResponse;
import com.gmatieso.ems.entity.Employee;

public class EmployeeMapper {


    //Mapping our employee Entity to employeeResponse DTO
    public static EmployeeDtoResponse mapToEmployeeDto(Employee employee){
        return new EmployeeDtoResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

    }

    //Mapping our employee DTO response to employee entity
    public static Employee mapToEmployee(EmployeeDtoResponse employeeDtoResponse){
        return new Employee(
                employeeDtoResponse.getId(),
                employeeDtoResponse.getFirstName(),
                employeeDtoResponse.getLastName(),
                employeeDtoResponse.getEmail()
        );
    }
}
