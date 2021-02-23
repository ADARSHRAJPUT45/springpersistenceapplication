package com.example.springpersistence.repository;

import com.example.springpersistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository <Employee, Long> {
}
