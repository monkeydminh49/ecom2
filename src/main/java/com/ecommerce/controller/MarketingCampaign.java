package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
@RequestMapping("/marketing")
public class MarketingCampaign {

    @GetMapping
    public String showCampaigns(Model model) {
        model.addAttribute("campaigns", generateMockCampaigns());
        model.addAttribute("stats", generateMockStats());
        return "marketing";
    }

    private List<Map<String, Object>> generateMockCampaigns() {
        List<Map<String, Object>> campaigns = new ArrayList<>();
        String[] statuses = {"Active", "Scheduled", "Ended"};
        String[] types = {"Email", "Social Media", "Push Notification", "SMS"};

        for (int i = 0; i < 6; i++) {
            Map<String, Object> campaign = new HashMap<>();
            campaign.put("id", "CAM-" + (1000 + i));
            campaign.put("name", "Campaign " + (i + 1));
            campaign.put("type", types[i % types.length]);
            campaign.put("status", statuses[i % statuses.length]);
            campaign.put("reach", (int)(Math.random() * 10000));
            campaign.put("conversion", (int)(Math.random() * 100));
            campaign.put("revenue", Math.round(Math.random() * 10000));
            campaign.put("startDate", "2024-" + ((i % 12) + 1) + "-01");
            campaign.put("endDate", "2024-" + ((i % 12) + 1) + "-28");
            campaigns.add(campaign);
        }
        return campaigns;
    }

    private Map<String, Object> generateMockStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalCampaigns", 6);
        stats.put("activeCustomers", 15420);
        stats.put("totalRevenue", 52840);
        stats.put("conversionRate", 68);
        return stats;
    }
}
