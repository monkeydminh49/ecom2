package com.ecommerce.dao.impl;

import com.ecommerce.dao.CustomerDAO;
import com.ecommerce.dao.repo.CustomerRepository;
import com.ecommerce.model.Customer;
import com.ecommerce.model.FullName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CustomerDAOImpl implements CustomerDAO {

    private final CustomerRepository customerRepository;

    @Override
    public Customer login(String email,
                          String password) {
        Optional<Customer> customer = customerRepository.findCustomerByEmailAndPassword(email, password);
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        return customer.get();
    }

    @Override
    public void signUp(String email, String password, String firstName, String lastName) {
        if (customerRepository.existsByEmail(email)) {
            throw new RuntimeException("Customer with email " + email + " already exist");
        }
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        FullName fullName = new FullName();
        fullName.setFirstName(firstName);
        fullName.setLastName(lastName);
        customer.setFullName(fullName);
        customerRepository.save(customer);
    }


}
