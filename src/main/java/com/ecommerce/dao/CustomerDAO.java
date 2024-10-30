package com.ecommerce.dao;

import com.ecommerce.model.Customer;

public interface CustomerDAO {
    Customer getCustomerById(int id);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}