package com.mabotalb.mvc_crud.service;

import com.mabotalb.mvc_crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
