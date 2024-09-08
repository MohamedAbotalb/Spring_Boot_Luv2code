package com.mabotalb.thymeleaf_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // Create a controller method to show the initial html form
    @RequestMapping("/showForm")
    public String showForm() {
        return "hello-world-form";
    }

    // Create a controller method to process the form submission
    @RequestMapping("/processFrom")
    public String processForm() {
        return "hello-world";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // Read the request parameter from the HTML form
        String name = request.getParameter("studentName");

        // Convert the data to uppercase
        name = name.toUpperCase();

        // Create the message
        String result = "Yo! " + name +  "!!";

        // Add the message to the model
        model.addAttribute("message", result);

        return "hello-world";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {

        // Convert the data to uppercase
        name = name.toUpperCase();

        // Create the message
        String result = "Hey my friend from v3 -> " + name +  "!!";

        // Add the message to the model
        model.addAttribute("message", result);

        return "hello-world";
    }
}
