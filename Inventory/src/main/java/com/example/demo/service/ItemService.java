package com.example.demo.service;

import com.example.demo.exception.InsufficientQuantityException;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.dao.IItemDao;
import com.example.demo.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    IItemDao itemDao;

    //save new item
    public Item saveItem(Item item){
        return itemDao.addItem(item);
    }

    //update item
    public Item updateItemInfo(Item item) {

        //check item exist
        Item it = getItemDetail(item.getId());

        it.setStock_quantity(item.getStock_quantity());
        it.setName(item.getName());
        it.setReorder_level(item.getReorder_level());
        it.setTax_percentage(item.getTax_percentage());
        it.setUnit(item.getUnit());
        it.setUnit_price(item.getUnit_price());

        //if yes update and return
        return itemDao.updateItem(it);
    }

    //get detail for a single item
    public Item getItemDetail(long id) {

        Item item = itemDao.getItem(id);

        if(item == null)
            throw new ItemNotFoundException("No such item present in inventory.");

        return item;
    }

    //get list of all items in db
    public List<Item> getAllItems() {

        List<Item> items = itemDao.getItemAll();

        return items;
    }

    //insert/receive item for replenish inventory-stock into inventory
    public Item receiveItem(long id, int quantity) {

        //check item exist
        Item item = getItemDetail(id);

        //update
        int currentQuantity = item.getStock_quantity();

        int updated_quantity = currentQuantity + quantity;

        item.setStock_quantity(updated_quantity);

        itemDao.updateItem(item);

        return item;
    }

    //issue item for replenish sale-stock from inventory
    public Item issueItem(long id, int issuedQuantity) {
        //check item exist
        Item item =  getItemDetail(id);

        //get current quantity
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

    //remove item from inventory
    public Item removeItemById(long itemId){
       Item item = itemDao.deleteItem(itemId);

       if(item == null)
           throw new ItemNotFoundException("No such item present in inventory.");

       return item;
    }
}
