package com.mabotalb.employees_rest_api.service;

import com.mabotalb.employees_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
