package com.mabotalb.employees_rest_api.rest;

import com.mabotalb.employees_rest_api.dao.EmployeeDAO;
import com.mabotalb.employees_rest_api.entity.Employee;
import com.mabotalb.employees_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        Employee employee = this.employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee isn't found with id " + id);
        }
        return employee;
    }

    @PostMapping()
    public Employee addEmployee(@RequestBody  Employee employee) {
        employee.setId(0);
        return this.employeeService.save(employee);
    }

    @PutMapping()
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        Employee employee = this.employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee isn't found with id " + id);
        }

        this.employeeService.deleteById(id);

        return "Deleted employee id = " + id;
    }

}
