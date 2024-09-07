package com.mabotalb.employees_rest_api.dao;

import com.mabotalb.employees_rest_api.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);
}
