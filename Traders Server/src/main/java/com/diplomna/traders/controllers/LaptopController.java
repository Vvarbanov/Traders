package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.LaptopDTO;
import com.diplomna.traders.DTOs.TVDTO;
import com.diplomna.traders.Models.Laptop;
import com.diplomna.traders.Models.TV;
import com.diplomna.traders.business.logic.LaptopHandler;
import com.diplomna.traders.business.logic.TVHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Laptops")
@RestController
public class LaptopController {

    @Autowired
    private LaptopHandler laptopHandler;

    @RequestMapping("/Create")
    public ResponseEntity<List<LaptopDTO>> createLaptop(@RequestBody List<LaptopDTO> laptopDTOS){

        laptopHandler.createNewLaptop(laptopDTOS);

        return ResponseEntity.ok(laptopDTOS);
    }

    @RequestMapping("/GetAll")
    public ResponseEntity getAllLaptops(){
        Iterable<Laptop> laptops = laptopHandler.getAllLaptop();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(laptops);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(objectMapper);
    }
}
