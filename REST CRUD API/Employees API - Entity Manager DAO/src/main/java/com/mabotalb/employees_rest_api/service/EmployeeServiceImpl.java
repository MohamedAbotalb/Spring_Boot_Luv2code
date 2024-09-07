package com.mabotalb.employees_rest_api.service;

import com.mabotalb.employees_rest_api.dao.EmployeeDAO;
import com.mabotalb.employees_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        this.employeeDAO.deleteById(id);
    }
}
