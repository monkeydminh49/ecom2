package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/report")
public class ReportController {

    @GetMapping("/{staffId}")
    public String getReport(@PathVariable String staffId, Model model) {
        // Mock data for demonstration
        List<Map<String, Object>> orders = generateMockOrders();

        // Calculate statistics
        double totalSales = orders.stream()
                .mapToDouble(order -> (Double) order.get("total"))
                .sum();

        Map<String, Double> monthlySales = new HashMap<>();
        Map<String, Integer> productSales = new HashMap<>();

        for (Map<String, Object> order : orders) {
            String month = (String) order.get("month");
            Double total = (Double) order.get("total");
            monthlySales.merge(month, total, Double::sum);

            @SuppressWarnings("unchecked")
            List<Map<String, Object>> items = (List<Map<String, Object>>) order.get("items");
            for (Map<String, Object> item : items) {
                String productName = (String) item.get("productName");
                productSales.merge(productName, (Integer) item.get("quantity"), Integer::sum);
            }
        }

        model.addAttribute("staffId", staffId);
        model.addAttribute("totalSales", totalSales);
        model.addAttribute("monthlySales", monthlySales);
        model.addAttribute("productSales", productSales);
        model.addAttribute("orders", orders);

        return "report";
    }

    private List<Map<String, Object>> generateMockOrders() {
        List<Map<String, Object>> orders = new ArrayList<>();
        String[] months = {"January", "February", "March", "April", "May", "June"};
        String[] products = {"Laptop", "Smartphone", "Tablet", "Headphones", "Smart Watch"};

        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Map<String, Object> order = new HashMap<>();
            order.put("orderId", "ORD-" + (1000 + i));
            order.put("month", months[random.nextInt(months.length)]);
            order.put("date", "2023-" + (random.nextInt(12) + 1) + "-" + (random.nextInt(28) + 1));

            List<Map<String, Object>> items = new ArrayList<>();
            int numItems = random.nextInt(3) + 1;
            double total = 0;

            for (int j = 0; j < numItems; j++) {
                Map<String, Object> item = new HashMap<>();
                String product = products[random.nextInt(products.length)];
                int quantity = random.nextInt(3) + 1;
                double price = (random.nextInt(900) + 100) * 1.0;

                item.put("productName", product);
                item.put("quantity", quantity);
                item.put("price", price);
                item.put("staffId", "STAFF-" + (random.nextInt(5) + 1));

                items.add(item);
                total += price * quantity;
            }

            order.put("items", items);
            order.put("total", total);
            orders.add(order);
        }

        return orders;
    }
}