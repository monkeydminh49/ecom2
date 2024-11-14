package com.ecommerce.repository;

import com.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO extends JpaRepository<Cart, String> {
    List<Cart> findByCustomerIdAndOrderIsNull(int customerId);

    List<Cart> findByCustomerId(int customerId);

    List<Cart> findByCustomerIdAndItemId(int customerId, int itemId);
}