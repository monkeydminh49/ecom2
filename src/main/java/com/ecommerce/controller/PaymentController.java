package com.ecommerce.controller;

import com.ecommerce.model.Payment;
import com.ecommerce.dao.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentDAO paymentDAO;

    @PostMapping("/process")
    public String processPayment(@ModelAttribute Payment payment) {
        paymentDAO.processPayment(payment);
        return "redirect:/order/" + payment.getId();
    }
}