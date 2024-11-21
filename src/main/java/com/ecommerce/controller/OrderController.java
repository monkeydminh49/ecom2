package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{customerId}")
    public String viewOrder(@PathVariable String customerId, Model model) {
        model.addAttribute("orders", orderService.getOrderByCustomerId(customerId));
        model.addAttribute("customerId", customerId);
        return "order";
    }

    @GetMapping("/staff/{staffId}")
    public String viewOrderStaff(@PathVariable String staffId, Model model) {
        model.addAttribute("orders", orderService.getOrderByStaffId(staffId));
        model.addAttribute("staffId", staffId);
        return "staff";
    }
}