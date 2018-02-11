package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.MeasurementUnitDto;
import com.diplomna.traders.business.logic.MeasurementUnitHandler;
import com.diplomna.traders.models.MeasurementUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/measurementUnits")
@RestController
public class MeasurementUnitController {

    @Autowired
    private MeasurementUnitHandler measurementUnitHandler;

    @RequestMapping(value = "/create", method = POST)
    public ResponseEntity<List<MeasurementUnitDto>> createMeasurementUnit(@RequestBody List<MeasurementUnitDto> measurementUnitDto){

        measurementUnitHandler.createNewMeasurementUnit(measurementUnitDto);

        return ResponseEntity.ok(measurementUnitDto);
    }
    
    @RequestMapping(value = "/getAll", method = GET)
    public ResponseEntity<Iterable<MeasurementUnit>> getAllMeasurementsUnits(){
        List<MeasurementUnitDto> objects = measurementUnitHandler.getAllMeasurementUnits();
        
        return new ResponseEntity(objects, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getById", method = GET)
    public ResponseEntity<MeasurementUnit> getMeasurementById(@RequestBody Long id){
        return new ResponseEntity<>(measurementUnitHandler.getMeasurementUnitById(id), HttpStatus.OK) ;
    }
}
