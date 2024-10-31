package com.ecommerce.dto;

import lombok.Data;

@Data
public class OrderData {
    private String customerId;
    private String paymentMethod;
    private String shippingMethod;
    private String timestamp;
}