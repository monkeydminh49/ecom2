package com.ecommerce.dao;

import com.ecommerce.model.Customer;

public interface CustomerDAO {
    Customer login(String email, String password);

    void signUp(String email, String password, String firstName, String lastName);
}