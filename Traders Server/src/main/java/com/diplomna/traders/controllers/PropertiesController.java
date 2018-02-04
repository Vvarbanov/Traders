package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.PropertiesDTO;
import com.diplomna.traders.business.logic.PropertiesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/properties")
@RestController
public class PropertiesController {

    @Autowired
    private PropertiesHandler propertiesHandler;

    @RequestMapping("/create")
    public ResponseEntity<List<PropertiesDTO>> createMeasurementUnit(@RequestBody List<PropertiesDTO> propertiesDTOS) {

        propertiesHandler.createNewProperty(propertiesDTOS);

        return ResponseEntity.ok(propertiesDTOS);
    }
}
