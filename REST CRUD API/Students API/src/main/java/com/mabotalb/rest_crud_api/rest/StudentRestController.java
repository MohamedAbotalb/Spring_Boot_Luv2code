package com.mabotalb.rest_crud_api.rest;

import java.util.ArrayList;
import java.util.List;

import com.mabotalb.rest_crud_api.exception.StudentErrorResponse;
import com.mabotalb.rest_crud_api.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        // Check if the student id is not in the students list
        if (this.students.size() <= id || id < 0) {
            throw new StudentNotFoundException("Student with id " + id + " is not found");
        }
        return this.students.get(id);
    }
}
