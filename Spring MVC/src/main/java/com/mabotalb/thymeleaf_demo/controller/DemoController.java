package com.mabotalb.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class DemoController {

    // Create a mapping for the hello page
    @GetMapping("/hello")
    public String helloPage(Model model) {

        model.addAttribute("data", LocalDateTime.now());

        return "hello";
    }
}
