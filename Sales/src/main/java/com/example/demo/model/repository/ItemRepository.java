package com.example.demo.model.repository;

import com.example.demo.model.entity.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Item addItem(Item item) {

        entityManager.persist(item);

        return item;
    }

    public Item deleteItem(long itemId) {

        Item item = getItem(itemId);

        entityManager.remove(item);

        return item;
    }

    public Item getItem(long itemId) {

        return entityManager.find(Item.class, itemId);
    }

    public Item updateItem(Item item) {

        return entityManager.merge(item);
    }
}
