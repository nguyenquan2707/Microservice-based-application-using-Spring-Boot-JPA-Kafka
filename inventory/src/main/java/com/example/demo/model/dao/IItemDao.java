package com.example.demo.model.dao;

import com.example.demo.model.entity.Item;

public interface IItemDao {

    Item addItem(Item item);

    Item deleteItem(long itemId);

    Item getItem(long itemId);

    Item updateItem(Item item);
}
