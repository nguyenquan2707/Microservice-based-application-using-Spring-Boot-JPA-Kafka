package com.example.demo.model.repository;

import com.example.demo.model.entity.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.MANDATORY)
    public Item addItem(Item item) {

        entityManager.persist(item);

        return item;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Item deleteItem(long itemId) {

        Item item = getItem(itemId);

        if(item != null)
            entityManager.remove(item);

        return item;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Item getItem(long itemId) {

        return entityManager.find(Item.class, itemId);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Item updateItem(Item item) {

        return entityManager.merge(item);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Item> getItemAll() {

        Query query = entityManager.createQuery("Select i from Item i");

        return query.getResultList();
    }
}
