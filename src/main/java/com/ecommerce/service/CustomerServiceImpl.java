package com.ecommerce.service;

import com.ecommerce.model.Customer;
import com.ecommerce.model.FullName;
import com.ecommerce.repository.CustomerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Override
    public Customer login(String email,
                      String password) {
        Optional<Customer> customer = customerDAO.findCustomerByEmailAndPassword(email, password);
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        return customer.get();
    }

    @Override
    public void signUp(String email, String password, String firstName, String lastName) {
        if (customerDAO.existsByEmail(email)) {
            throw new RuntimeException("Customer with email " + email + " already exist");
        }
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);
        FullName fullName = new FullName();
        fullName.setFirstName(firstName);
        fullName.setLastName(lastName);
        customer.setFullName(fullName);
        customerDAO.save(customer);
    }


}
