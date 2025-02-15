package com.gmatieso.ems.service.impl;

import com.gmatieso.ems.dto.EmployeeDtoResponse;
import com.gmatieso.ems.entity.Employee;
import com.gmatieso.ems.mapper.EmployeeMapper;
import com.gmatieso.ems.repository.EmployeeRepository;
import com.gmatieso.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDtoResponse createEmployee(EmployeeDtoResponse employeeDtoResponse) {
        // convert the employee dto to entity...
        Employee employee = EmployeeMapper.mapToEmployee(employeeDtoResponse);
        // save to our database
       Employee savedEmployee =  employeeRepository.save(employee);
       // convert our saved employee entity to dto and return it as a response.
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
