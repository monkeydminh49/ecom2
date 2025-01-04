package com.ecommerce.controller;

import com.ecommerce.dao.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository.OrderDAO orderDAO;

    @GetMapping("/{customerId}")
    public String viewOrder(@PathVariable String customerId, Model model) {
        model.addAttribute("orders", orderDAO.getOrderByCustomerId(customerId));
        model.addAttribute("customerId", customerId);
        return "order";
    }

    @GetMapping("/staff/{staffId}")
    public String viewOrderStaff(@PathVariable String staffId, Model model) {
        model.addAttribute("orders", orderDAO.getOrderByStaffId(staffId));
        model.addAttribute("staffId", staffId);
        return "staff";
    }
}