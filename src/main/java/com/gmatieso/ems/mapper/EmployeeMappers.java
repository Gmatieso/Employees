package com.gmatieso.ems.mapper;

import com.gmatieso.ems.dto.EmployeeRequest;
import com.gmatieso.ems.dto.EmployeeResponse;
import com.gmatieso.ems.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMappers {

    EmployeeResponse employeeToEmployeeRespond(Employee employee);

    Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);
}
