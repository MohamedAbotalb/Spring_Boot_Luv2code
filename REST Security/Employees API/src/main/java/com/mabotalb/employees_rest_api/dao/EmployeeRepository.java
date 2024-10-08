package com.mabotalb.employees_rest_api.dao;

import com.mabotalb.employees_rest_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
