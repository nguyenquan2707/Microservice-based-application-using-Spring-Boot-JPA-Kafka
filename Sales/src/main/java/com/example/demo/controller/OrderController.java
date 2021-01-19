package com.example.demo.controller;

import com.example.demo.model.entity.Item;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.Response;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Response<Order>> createOrder(@RequestBody Order order){

        Response<Order> response = new Response<>();

        Order ord = orderService.registerOrder(order);

        response.setSuccess(true);
        response.setData(ord);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(value = "/customer/{mobileNo}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<Response<String>> removeOrderByCustomerMobNo(@PathVariable String mobileNo){

        Response<String> response = new Response<>();

        int numberOfOrderRemoved = orderService.removeAllOrdersForCustomer(mobileNo);

        response.setSuccess(true);
        response.setData("Total "+numberOfOrderRemoved+" order removed.");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //url : /order/customer/9609275425
    @RequestMapping(value = "/customer/{mobileNo}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Response<List<Order>>> getOrderByCustomerMobNo(@PathVariable String mobileNo){

        Response<List<Order>> response = new Response<>();

        List<Order> orderList = orderService.getAllOrder(mobileNo);

        response.setSuccess(true);
        response.setData(orderList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Response<Order>> updateOrder(@RequestBody Order order){

        return null;
    }

    //url : /order/12345
    @RequestMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<Response<Order>> removeOrderById(@PathVariable long orderId){

        Response<Order> response = new Response<>();

        Order order = orderService.removeOrderById(orderId);

        response.setSuccess(true);
        response.setData(order);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //url : /order/item/12345/quantity?q=1
    @RequestMapping(value = "/item/{itemId}/quantity", produces = MediaType.APPLICATION_JSON_VALUE, method =
            RequestMethod.PUT)
    public ResponseEntity<Response<Item>> replenishStock(@PathVariable("itemId") int itemId, @RequestParam("q")int quantity){

        Response<Item> response = new Response<>();

        Item item = itemService.stockReplenishMent(itemId, quantity);

        response.setSuccess(true);
        response.setData(item);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //getItemById(id)
    //url : /order/item/12345
    @RequestMapping(value = "/item/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Response<Item>> getItemById(@PathVariable long itemId){

        Response<Item> response = new Response<>();

        Item item = itemService.getItemDetail(itemId);

        response.setSuccess(true);
        response.setData(item);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //save new item
    //url : /order/item
    @RequestMapping(value = "/item", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Response<Item>> saveItem(@RequestBody Item item){

        Item it = itemService.saveItem(item);

        Response<Item> response = new Response<>();

        response.setSuccess(true);
        response.setData(it);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //getItemAll(id)
    //url : /order/item/all
    @RequestMapping(value = "/item/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Response<List<Item>>> getItemAll(){

        Response<List<Item>> response = new Response<>();

        List<Item> itemList = itemService.getAllItems();

        response.setSuccess(true);
        response.setData(itemList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //getItemById(id)
    //url : /order/item/12345
    @RequestMapping(value = "/item/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<Response<Item>> removeItemById(@PathVariable long itemId){

        Response<Item> response = new Response<>();

        Item item = itemService.removeItemById(itemId);

        response.setSuccess(true);
        response.setData(item);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
