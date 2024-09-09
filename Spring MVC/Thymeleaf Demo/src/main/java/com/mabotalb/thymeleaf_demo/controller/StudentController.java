package com.mabotalb.thymeleaf_demo.controller;

import com.mabotalb.thymeleaf_demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${favorite-languages}")
    private List<String> favoriteLanguages;

    @Value("${favorite-systems}")
    private List<String> favoirteSystems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model) {

        // Create a new student object
        Student student = new Student();

        // Add the student object to the model
        model.addAttribute("student", student);

        // Add the list of countries to the model
        model.addAttribute("countries", countries);

        // Add the list of favorite languages to the model
        model.addAttribute("favoriteLanguages", favoriteLanguages);

        // Add the list of favorite systems to the model
        model.addAttribute("favoriteSystems", favoirteSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student) {

        // Log the submitted student details
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }
}
