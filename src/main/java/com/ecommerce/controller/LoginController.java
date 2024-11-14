package com.ecommerce.controller;


import com.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final CustomerService customerService;


    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String email,
                        @RequestParam String password) {
        log.info("Login request for email: {} {} {} {}", email, password);
        var customer = customerService.login(email, password);
        return "redirect:/" + customer.getId() + "/";
    }


}
