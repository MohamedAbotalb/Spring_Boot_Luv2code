package com.mabotalb.mvc_crud.service;

import com.mabotalb.mvc_crud.dao.EmployeeRepository;
import com.mabotalb.mvc_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result = this.employeeRepository.findById(id);
        Employee employee = null;

        if(result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee isn't found with id " + id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
