package com.ecommerce.dao;

import com.ecommerce.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    public Customer getCustomerById(int id) { return null; }
    public void addCustomer(Customer customer) {}
    public void updateCustomer(Customer customer) {}
    public void deleteCustomer(int id) {}
}