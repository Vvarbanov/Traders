package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.ObjectDTO;
import com.diplomna.traders.Models.MyObject;
import com.diplomna.traders.business.logic.ObjectHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/Object/")
@RestController
public class ObjectController {

    @Autowired
    private ObjectHandler objectHandler;

    @RequestMapping("/Create")
    public ResponseEntity<List<ObjectDTO>> createTV(@RequestBody List<ObjectDTO> objectDTOS){

        objectHandler.createNewObject(objectDTOS);

        return ResponseEntity.ok(objectDTOS);
    }

    @RequestMapping(value = "/GetAll",method = GET)
    public ResponseEntity<Iterable<MyObject>> getAllLaptops(){
        List<ObjectDTO> laptops = objectHandler.getAllObjects();

        return new ResponseEntity(laptops, HttpStatus.OK);
    }
}
