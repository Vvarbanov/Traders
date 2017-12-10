package com.diplomna.traders.controllers;

import com.diplomna.traders.DTOs.MeasurementUnitDTO;
import com.diplomna.traders.business.logic.MeasurementUnitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/MeasurementUnit")
@RestController
public class MeasurementUnitController {


    @Autowired
    private MeasurementUnitHandler measurementUnitHandler;

    @RequestMapping("/Create")
    public ResponseEntity<List<MeasurementUnitDTO>> createItem(@RequestBody List<MeasurementUnitDTO> measurementUnitDTO){

        measurementUnitHandler.createNewMeasurementUnit(measurementUnitDTO);

        return ResponseEntity.ok(measurementUnitDTO);
    }

}
