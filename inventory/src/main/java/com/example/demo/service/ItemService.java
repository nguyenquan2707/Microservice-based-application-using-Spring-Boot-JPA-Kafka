package com.example.demo.service;

import com.example.demo.exception.InsufficientQuantityException;
import com.example.demo.exception.ItemNotExistException;
import com.example.demo.model.dao.IItemDao;
import com.example.demo.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    IItemDao itemDao;

    //get detail for a single item
    public Item getItemDetail(long id) throws ItemNotExistException {

        Item item = itemDao.getItem(id);

        if(item == null)
            throw new ItemNotExistException("No such item present in inventory.");

        return item;
    }

    //insert/receive item for replenish inventory-stock into inventory
    public Item receiveItem(long id, int quantity) throws ItemNotExistException {

        //check item exist
        Item item = itemDao.getItem(id);

        //if no , throw exception
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

    //issue item for replenish sale-stock from inventory
    public Item issueItem(long id, int issuedQuantity) throws ItemNotExistException, InsufficientQuantityException {
        //check item exist
        Item item = itemDao.getItem(id);

        //if no , throw exception
        if(item == null)
            throw new ItemNotExistException("No such item present in inventory.");

        //if yes get current quantity
        int currentQuantity = item.getStock_quantity();

        //if current quantity is less than required, throw exception
        if(currentQuantity < issuedQuantity)
            throw new InsufficientQuantityException("Not enough quantity is available in the inventory for "+item.getName());

        //else update inventory
        int updated_quantity = currentQuantity - issuedQuantity;

        //update
        item.setStock_quantity(updated_quantity);

        itemDao.updateItem(item);

        return item;

    }
}
