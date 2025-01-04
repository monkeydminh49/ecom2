package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/support")
public class CustomerSupport {

    // Mock data storage (replace with actual repository in production)
    private List<SupportTicket> tickets = new ArrayList<>();

    @GetMapping("")
    public String supportDashboard(Model model) {
        model.addAttribute("tickets", tickets);
        return "customer-support";
    }

    @PostMapping("/ticket/create")
    @ResponseBody
    public SupportTicket createTicket(@RequestBody SupportTicket ticket) {
        ticket.setId(UUID.randomUUID().toString());
        ticket.setStatus("Open");
        tickets.add(ticket);
        return ticket;
    }

    @PutMapping("/ticket/{id}")
    @ResponseBody
    public SupportTicket updateTicket(@PathVariable String id, @RequestBody SupportTicket updatedTicket) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getId().equals(id)) {
                updatedTicket.setId(id);
                tickets.set(i, updatedTicket);
                return updatedTicket;
            }
        }
        return null;
    }

    @DeleteMapping("/ticket/{id}")
    @ResponseBody
    public boolean deleteTicket(@PathVariable String id) {
        return tickets.removeIf(ticket -> ticket.getId().equals(id));
    }
}

// Mock DTO class (move to separate file in production)
class SupportTicket {
    private String id;
    private String subject;
    private String description;
    private String status;
    private String priority;
    private String customerEmail;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
}
