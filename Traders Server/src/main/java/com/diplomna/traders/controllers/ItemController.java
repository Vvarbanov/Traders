package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.ItemDTO;
import com.diplomna.traders.business.logic.ItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Item")
@RestController
public class ItemController {

    @Autowired
    private ItemHandler itemHandler;

    @RequestMapping("/Create")
    public ResponseEntity<List<ItemDTO>> createItem(@RequestBody List<ItemDTO> itemDTO){

        itemHandler.createNewItem(itemDTO);

        return ResponseEntity.ok(itemDTO);
    }

}
