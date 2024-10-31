package com.ecommerce.util;

import java.util.Arrays;
import java.util.List;

public class OrderStatusUtil {
    public static List<String> getOrderStatuses() {
        return Arrays.asList("Pending", "Processing", "Delivered");
    }
}