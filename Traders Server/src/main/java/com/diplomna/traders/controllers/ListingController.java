package com.diplomna.traders.controllers;

import com.diplomna.traders.business.logic.ListingHandler;
import com.diplomna.traders.dtos.ListingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RequestMapping("/listings")
@RestController
public class ListingController {
    
    @Autowired
    private ListingHandler listingHandler;
    
    @RequestMapping("/create")
    public ResponseEntity<List<ListingDTO>> createItem(@RequestBody List<ListingDTO> listingDTOS){
    
        listingHandler.createNewListing(listingDTOS);
        
        return ResponseEntity.ok(listingDTOS);
    }
    
    @RequestMapping(value = "/getAll", method = GET)
    public ResponseEntity<Iterable<ListingDTO>> getAllItems(){
        List<ListingDTO> objects = listingHandler.getAllListings();
        
        return new ResponseEntity(objects, HttpStatus.OK);
    }
    
}
