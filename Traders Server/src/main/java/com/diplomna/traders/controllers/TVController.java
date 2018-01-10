package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.TVDTO;
import com.diplomna.traders.Models.TV;
import com.diplomna.traders.business.logic.TVHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/TVs")
@RestController
public class TVController {

    @Autowired
    private TVHandler tvHandler;

    @RequestMapping("/Create")
    public ResponseEntity<List<TVDTO>> createTV(@RequestBody List<TVDTO> tvDTOs){

        tvHandler.createNewTV(tvDTOs);

        return ResponseEntity.ok(tvDTOs);
    }

    @RequestMapping("/GetAll")
    public ResponseEntity getAllTVs(){
        Iterable<TV> tvs = tvHandler.getAllTV();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(tvs);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(objectMapper);
    }
}
