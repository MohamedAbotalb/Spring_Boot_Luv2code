package com.mabotalb.rest_crud_api.rest;

import com.mabotalb.rest_crud_api.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @GetMapping()
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Mohamed", "Abotalb"));
        students.add(new Student("Ahmed", "Abotalb"));
        students.add(new Student("Mahmoud", "Abotalb"));

        return students;
    }
}
