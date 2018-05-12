package com.diplomna.traders.Controllers;

import com.diplomna.traders.DTOs.MeasurementUnitDTO;
import com.diplomna.traders.business.Logic.MeasurementUnitHandler;
import com.diplomna.traders.Models.MeasurementUnit;
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
    public ResponseEntity<List<MeasurementUnitDTO>> createMeasurementUnit(@RequestBody List<MeasurementUnitDTO> measurementUnitDTO){

        measurementUnitHandler.createNewMeasurementUnit(measurementUnitDTO);

        return ResponseEntity.ok(measurementUnitDTO);
    }
    
    @RequestMapping(value = "/getAll", method = GET)
    public ResponseEntity<Iterable<MeasurementUnit>> getAllMeasurementsUnits(){
        List<MeasurementUnitDTO> objects = measurementUnitHandler.getAllMeasurementUnits();
        
        return new ResponseEntity(objects, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getById", method = GET)
    public ResponseEntity<MeasurementUnit> getMeasurementById(@RequestBody Long id){
        return new ResponseEntity<>(measurementUnitHandler.getMeasurementUnitById(id), HttpStatus.OK) ;
    }
}
