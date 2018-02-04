package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.MeasurementUnitDTO;
import com.diplomna.traders.business.logic.MeasurementUnitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/measurementUnits")
@RestController
public class MeasurementUnitController {


    @Autowired
    private MeasurementUnitHandler measurementUnitHandler;

    @RequestMapping("/create")
    public ResponseEntity<List<MeasurementUnitDTO>> createMeasurementUnit(@RequestBody List<MeasurementUnitDTO> measurementUnitDTO){

        measurementUnitHandler.createNewMeasurementUnit(measurementUnitDTO);

        return ResponseEntity.ok(measurementUnitDTO);
    }
}
