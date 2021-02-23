package com.example.springpersistence.service.Impl.Impl;

import com.example.springpersistence.dto.EmployeeRequestDto;
import com.example.springpersistence.dto.EmployeeResponsedto;
import com.example.springpersistence.entity.Employee;
import com.example.springpersistence.repository.EmployeeRepository;
import com.example.springpersistence.service.Impl.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponsedto saveDetails(EmployeeRequestDto employeeRequestDto)
    {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestDto, employee);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponsedto employeeResponsedto= new EmployeeResponsedto();
        BeanUtils.copyProperties(savedEmployee, employeeResponsedto);
        return employeeResponsedto;
    }

    @Override
    public EmployeeResponsedto findById(long id)
    {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent())
        {
            EmployeeResponsedto employeeResponsedto = new EmployeeResponsedto();
            BeanUtils.copyProperties(employeeOptional.get(), employeeResponsedto);
            return employeeResponsedto;
        }
        else {
            return null;
        }
    }

    @Override
    public EmployeeResponsedto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDto){
        Optional<Employee>employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            //copy from employee
            Employee employeeFromDb=employeeOptional.get();
            employeeFromDb.setName(employeeRequestDto.getName());
            employeeFromDb.setDepartmentName(employeeRequestDto.getDepartmentName());
            //save to db
            Employee savedEmployee=employeeRepository.save(employeeFromDb);
            //copy from employee to responseDTO
            EmployeeResponsedto responseDTO=new EmployeeResponsedto();
            BeanUtils.copyProperties(savedEmployee,responseDTO);
            return responseDTO;
        }
        return null;
    }


    @Override
    public EmployeeResponsedto deleteEmployeeById(Long id, EmployeeRequestDto employeeRequestDto){
        Optional<Employee>employeeOptional=employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            //copy from employee to response dto

            EmployeeResponsedto responseDTO=new EmployeeResponsedto();
            BeanUtils.copyProperties(employeeOptional.get(),responseDTO);
            employeeRepository.deleteById(id);
            return responseDTO;
        }
        return null;
    }
}
