package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.PropertiesDTO;
import com.diplomna.traders.business.logic.PropertiesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/properties")
@RestController
public class PropertiesController {

    @Autowired
    private PropertiesHandler propertiesHandler;

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<List<PropertiesDTO>> createMeasurementUnit(@RequestBody List<PropertiesDTO> propertiesDTOs) {

        propertiesHandler.createNewProperty(propertiesDTOs);

        return ResponseEntity.ok(propertiesDTOs);
    }
}
