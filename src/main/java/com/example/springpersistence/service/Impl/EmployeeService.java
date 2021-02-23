package com.example.springpersistence.service.Impl;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponsedto;

public interface EmployeeService {

    EmployeeResponsedto saveDetails(EmployeeRequestDto employeeRequestDto);
    EmployeeResponsedto findById(long id);

    EmployeeResponsedto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDto);

    EmployeeResponsedto deleteEmployeeById(Long id, EmployeeRequestDto employeeRequestDto);
}
