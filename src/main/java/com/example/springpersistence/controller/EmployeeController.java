package com.example.springpersistence.controller;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponsedto;
import com.example.springpersistence.entity.Employee;
import com.example.springpersistence.service.Impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeResponsedto saveDetails(@RequestBody EmployeeRequestDto employeeRequestDto)
    {

        return employeeService.saveDetails(employeeRequestDto);
    }

    @PostMapping(value = "/{id}")
    public EmployeeResponsedto findById(@PathVariable("id") long id)
    {
        return employeeService.findById(id);
    }

    //PUT     /employee/{id}
    @PutMapping("/{id}")
    public EmployeeResponsedto updateEmployee(@PathVariable("id")Long id,@RequestBody EmployeeRequestDto employeeRequestDTO){
        return employeeService.updateEmployeeById(id,employeeRequestDTO);
    }
    //DELETE   /employee{id}

    @DeleteMapping("/{id}")
    public EmployeeResponsedto deleteEmployee(@PathVariable("id")Long id,@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.deleteEmployeeById(id,employeeRequestDto);
    }

}
