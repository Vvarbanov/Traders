package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.ObjectDTO;
import com.diplomna.traders.models.MyObject;
import com.diplomna.traders.business.logic.ObjectHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("objects")
@RestController
public class ObjectController {

    @Autowired
    private ObjectHandler objectHandler;

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<List<ObjectDTO>> CreateObject(@RequestBody List<ObjectDTO> objectDTOs){

        objectHandler.createNewObject(objectDTOs);

        return ResponseEntity.ok(objectDTOs);
    }

    @RequestMapping(value = "/getAll", method = GET)
    public ResponseEntity<Iterable<MyObject>> getAllLaptops(){
        List<ObjectDTO> objects = objectHandler.getAllObjects();

        return new ResponseEntity(objects, HttpStatus.OK);
    }
}
