package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // Display the home page at a different endpoint
    @GetMapping("/ư")
    public String home(Model model) {
        // Adding a welcome message attribute for the template
        model.addAttribute("welcomeMessage", "Welcome to the Home Page!");
        return "index"; // Refers to index.html in the templates folder
    }
}