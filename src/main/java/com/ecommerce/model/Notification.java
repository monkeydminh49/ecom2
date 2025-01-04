package com.ecommerce.model;

import com.ecommerce.dao.CustomerDAO;

import java.util.Date;

public class Notification {
    private int id;
    private Customer customer;
    private NotificationType type;
    private String content;
    private boolean isRead;
    private Date createdAt;
}
