package com.ecommerce.dao.repo;

import com.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);

    Optional<Customer> findCustomerByEmailAndPassword(String email, String password);
}
