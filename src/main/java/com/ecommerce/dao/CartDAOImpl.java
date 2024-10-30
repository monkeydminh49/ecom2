package com.ecommerce.dao;

import com.ecommerce.model.Cart;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class CartDAOImpl implements CartDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Cart> getCartByCustomerId(String idCustomer) {
        System.out.println("idCustomer: " + idCustomer);
        try {
            return (List<Cart>) entityManager.createQuery("SELECT c FROM Cart c WHERE c.customerId = :customerId")
                    .setParameter("customerId", idCustomer)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle this based on your error-handling policy
        }
    }

    @Override
    @Transactional
    public void createCart(Cart cart) {
        entityManager.persist(cart);
    }

    @Override
    @Transactional
    public void updateCart(Cart cart) {
        entityManager.merge(cart);
    }

    @Override
    @Transactional
    public void deleteCart(String idCart) {
        Cart cart = entityManager.find(Cart.class, Long.parseLong(idCart));
        if (cart != null) {
            entityManager.remove(cart);
        }
    }
}