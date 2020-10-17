package com.example.demo.model.repository;

import com.example.demo.model.dao.IItemDao;
import com.example.demo.model.entity.Item;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class ItemRepository implements IItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item addItem(Item item) {

        entityManager.persist(item);

        return item;
    }

    @Override
    public Item deleteItem(long itemId) {

        Item item = getItem(itemId);

        if(item != null)
            entityManager.remove(item);

        return item;
    }

    @Override
    public Item getItem(long itemId) {

        return entityManager.find(Item.class, itemId);
    }

    @Override
    public List<Item> getItemAll() {

        Query query = entityManager.createQuery("Select i from Item i");

        return query.getResultList();
    }

    @Override
    public Item updateItem(Item item) {

        return entityManager.merge(item);
    }
}
