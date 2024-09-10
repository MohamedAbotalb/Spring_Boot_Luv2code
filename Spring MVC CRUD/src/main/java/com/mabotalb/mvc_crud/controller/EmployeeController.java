package com.mabotalb.mvc_crud.controller;

import com.mabotalb.mvc_crud.entity.Employee;
import com.mabotalb.mvc_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getAllEmployees(Model model) {

        // Retrieve all employees from the database
        List<Employee> employees = this.employeeService.findAll();

        // Add the list of employees to the model
        model.addAttribute("employees", employees);

        return "employees/employees-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // Create a new employee object and add it to the model
        model.addAttribute("employee", new Employee());

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // Save the employee to the database
        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

        // Retrieve the employee with the given ID from the database
        Employee employee = employeeService.findById(id);

        // Add the employee to the model
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }
}
