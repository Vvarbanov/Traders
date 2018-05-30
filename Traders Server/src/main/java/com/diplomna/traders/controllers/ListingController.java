package com.diplomna.traders.controllers;

import com.diplomna.traders.business.logic.ListingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/listings")
@RestController
public class ListingController {
    
    
    
    @Autowired
    private ListingHandler itemHandler;
    
    @RequestMapping("/create")
    public ResponseEntity<List<ItemDTO>> createItem(@RequestBody List<ItemDTO> itemDTO){
        
        itemHandler.createNewItem(itemDTO);
        
        return ResponseEntity.ok(itemDTO);
    }
    
    @RequestMapping(value = "/getAll", method = GET)
    public ResponseEntity<Iterable<ItemDTO>> getAllItems(){
        List<ItemDTO> objects = itemHandler.getAllItems();
        
        return new ResponseEntity(objects, HttpStatus.OK);
    }
    
}
