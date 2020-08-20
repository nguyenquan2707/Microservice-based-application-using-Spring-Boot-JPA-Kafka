package com.example.demo.controller;

import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item/")
public class ItemController {

    @Autowired
    ItemService itemService;

    //getItemDetail(id)

    //receiveItem(id, quantity)

    //issueItem(id, quantity)
}
