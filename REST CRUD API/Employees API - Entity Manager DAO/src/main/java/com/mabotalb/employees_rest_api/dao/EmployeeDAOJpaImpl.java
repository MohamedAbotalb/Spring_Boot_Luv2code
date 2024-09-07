package com.mabotalb.employees_rest_api.dao;

import com.mabotalb.employees_rest_api.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query
        TypedQuery<Employee> query = this.entityManager.createQuery("FROM Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.entityManager.merge(employee);
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee = this.entityManager.find(Employee.class, id);
        this.entityManager.remove(employee);
    }
}
