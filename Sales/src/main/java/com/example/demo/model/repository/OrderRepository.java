package com.example.demo.model.repository;

import com.example.demo.model.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Order saveOrder(Order order) {

        entityManager.persist(order);

        return order;
    }

    public Order getOrderByID(long orderId) {

        return entityManager.find(Order.class, orderId);
    }

    public List<Order> getOrderList(long customerId) {

        Query query = entityManager.createQuery("Select o from Order o where o.customerId = "+customerId);

        List<Order> orders = query.getResultList();

        return orders;
    }

    public Order updateOrder(Order order) {

        return entityManager.merge(order);
    }

    public Order deleteOrder(long orderId) {

        Order order = getOrderByID(orderId);

        entityManager.remove(order);

        return order;
    }
}
