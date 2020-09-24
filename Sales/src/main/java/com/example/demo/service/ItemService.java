package com.example.demo.service;

import com.example.demo.exception.ItemNotExistException;
import com.example.demo.model.entity.Item;
import com.example.demo.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    //save/add new item taken from inventory
    public Item saveItem(Item item){
        return itemRepository.addItem(item);
    }

    //get detail for a single item
    public Item getItemDetail(long id) {

        Item item = itemRepository.getItem(id);

        if(item == null)
            throw new ItemNotExistException("No such item present in inventory.");

        return item;
    }

    //replenish stock of item taken from inventory
    public Item stockReplenishMent(long id, int quantity) {

        //check item exist
        Item item = getItemDetail(id);

        //update
        int currentQuantity = item.getStockQuantity();

        int updated_quantity = currentQuantity + quantity;

        item.setStockQuantity(updated_quantity);

        itemRepository.updateItem(item);

        return item;
    }

}
