package com.gmatieso.ems.service.impl;

import com.gmatieso.ems.dto.EmployeeDtoResponseOld;
import com.gmatieso.ems.dto.EmployeeRequest;
import com.gmatieso.ems.dto.EmployeeResponse;
import com.gmatieso.ems.entity.Employee;
import com.gmatieso.ems.mapper.EmployeeMapper;
import com.gmatieso.ems.mapper.EmployeeMappers;
import com.gmatieso.ems.repository.EmployeeRepository;
import com.gmatieso.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMappers    employeeMappers;
//
    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        // convert the employee Request to entity...
        Employee employee = employeeMappers.employeeRequestToEmployee(employeeRequest);
        // save to our database
        Employee savedEmployee =  employeeRepository.save(employee);
//       // convert our saved employee entity to dto and return it as a response.
//        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
          EmployeeResponse  newEmployee =  employeeMappers.employeeToEmployeeRespond(savedEmployee);
    }
}
