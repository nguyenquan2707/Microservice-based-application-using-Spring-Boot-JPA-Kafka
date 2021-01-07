package com.example.demo.service;

import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.exception.NoItemFoundException;
import com.example.demo.model.entity.Item;
import com.example.demo.model.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    //save/add new item taken from inventory
    @Transactional(propagation = Propagation.REQUIRED)
    public Item saveItem(Item item){
        return itemRepository.addItem(item);
    }

    //get detail for a single item
    @Transactional(propagation = Propagation.SUPPORTS)
    public Item getItemDetail(long id) {

        Item item = itemRepository.getItem(id);

        if(item == null)
            throw new ItemNotFoundException("No such item present in inventory.");

        return item;
    }

    //replenish stock of item taken from inventory
    @Transactional(propagation = Propagation.REQUIRED)
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

    //get list of all items in db
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Item> getAllItems() {

        List<Item> items = itemRepository.getItemAll();

        if(items.size() == 0)
            throw new NoItemFoundException("No item left in the stock.");

        return items;
    }

    //remove item from inventory
    @Transactional(propagation = Propagation.REQUIRED)
    public Item removeItemById(long itemId){
        Item item = itemRepository.deleteItem(itemId);

        if(item == null)
            throw new ItemNotFoundException("No such item present in inventory.");

        return item;
    }

    //update item
    @Transactional(propagation = Propagation.REQUIRED)
    public Item updateItem(Item item){

        return itemRepository.updateItem(item);
    }

}
