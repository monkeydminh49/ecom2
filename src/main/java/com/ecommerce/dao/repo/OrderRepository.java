package com.ecommerce.dao.repo;

import com.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(int customerId);


    @Query(value = "SELECT o FROM Order o JOIN o.cart c JOIN c.item i WHERE i.staffId = :staffId")
    List<Order> findByStaffId(@Param("staffId") String staffId);

    interface OrderDAO {
        Order getOrderById(int orderId);
        void createOrder(Order order);

        List<Order> getOrderByCustomerId(String customerId);

        List<Order> getOrderByStaffId(String staffId);
    }
}