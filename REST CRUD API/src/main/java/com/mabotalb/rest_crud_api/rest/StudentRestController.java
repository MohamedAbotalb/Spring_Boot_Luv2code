package com.mabotalb.rest_crud_api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mabotalb.rest_crud_api.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        this.students = new ArrayList<>();

        students.add(new Student("Mohamed", "Abotalb"));
        students.add(new Student("Ahmed", "Abotalb"));
        students.add(new Student("Mahmoud", "Abotalb"));
    }

    @GetMapping()
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return this.students.get(id);
    }
}
