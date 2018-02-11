package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.ItemDto;
import com.diplomna.traders.business.logic.ItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemHandler itemHandler;

    @RequestMapping("/create")
    public ResponseEntity<List<ItemDto>> createItem(@RequestBody List<ItemDto> itemDto){

        itemHandler.createNewItem(itemDto);

        return ResponseEntity.ok(itemDto);
    }
    
    @RequestMapping(value = "/getAll", method = GET)
    public ResponseEntity<Iterable<ItemDto>> getAllItems(){
        List<ItemDto> objects = itemHandler.getAllItems();
        
        return new ResponseEntity(objects, HttpStatus.OK);
    }
}
