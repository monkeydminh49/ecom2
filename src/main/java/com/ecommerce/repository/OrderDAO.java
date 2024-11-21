package com.ecommerce.repository;

import com.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(int customerId);


    @Query(value = "SELECT o FROM Order o JOIN o.cart c JOIN c.item i WHERE i.staffId = :staffId")
    List<Order> findByStaffId(@Param("staffId") String staffId);
}