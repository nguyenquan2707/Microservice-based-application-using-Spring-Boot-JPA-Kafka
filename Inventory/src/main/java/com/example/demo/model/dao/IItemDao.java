package com.example.demo.model.dao;

import com.example.demo.model.entity.Item;

import java.util.List;

public interface IItemDao {

    Item addItem(Item item);

    Item deleteItem(long itemId);

    Item getItem(long itemId);

    List<Item> getItemAll();

    Item updateItem(Item item);
}
