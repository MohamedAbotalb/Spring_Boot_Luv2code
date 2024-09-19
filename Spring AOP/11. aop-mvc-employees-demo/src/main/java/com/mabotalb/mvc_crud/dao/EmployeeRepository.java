package com.mabotalb.mvc_crud.dao;

import com.mabotalb.mvc_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Add a method to sort by last name in ascending order
    List<Employee> findAllByOrderByLastNameAsc();

}
