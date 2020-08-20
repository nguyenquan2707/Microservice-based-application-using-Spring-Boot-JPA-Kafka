package com.example.demo.service;

import com.example.demo.exception.ItemNotExistException;
import com.example.demo.model.dao.IItemDao;
import com.example.demo.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    IItemDao itemDao;

    //getItemDetail(id)
    public Item getItemDetail(long id) throws ItemNotExistException {

        Item item = itemDao.getItem(id);

        if(item == null)
            throw new ItemNotExistException("No such item present in inventory.");

        return item;
    }

    //receiveItem(id, quantity)
    public Item receiveItem(long id, int quantity) throws ItemNotExistException {

        //check item exist
        Item item = itemDao.getItem(id);

        //it no , throw exception
        if(item == null)
            throw new ItemNotExistException("No such item present in inventory.");

        //if yes update
        int currentQuantity = item.getStock_quantity();

        int updated_quantity = currentQuantity + quantity;

        //update
        item.setStock_quantity(updated_quantity);

        itemDao.addItem(item);

        return item;
    }

    //issueItem(id, quantity)
}
