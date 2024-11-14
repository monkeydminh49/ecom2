package com.ecommerce.service;

import com.ecommerce.model.Customer;

public interface CustomerService {
    Customer login(String email, String password);

    void signUp(String email, String password, String firstName, String lastName);
}
