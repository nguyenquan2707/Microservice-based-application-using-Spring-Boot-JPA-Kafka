package com.example.demo.model.repository;

import com.example.demo.model.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Order saveOrder(Order order) {

        entityManager.persist(order);

        return order;
    }

    public Order getOrder(long orderId) {

        return entityManager.find(Order.class, orderId);
    }

    public Order updateOrder(Order order) {

        return entityManager.merge(order);
    }

    public Order deleteOrder(long orderId) {

        Order order = getOrder(orderId);

        entityManager.remove(order);

        return order;
    }
}
