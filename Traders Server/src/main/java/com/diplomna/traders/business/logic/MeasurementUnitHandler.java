package com.diplomna.traders.business.Logic;

import com.diplomna.traders.DTOs.MeasurementUnitDTO;
import com.diplomna.traders.Models.MeasurementUnit;
import com.diplomna.traders.Repository.MeasurementUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeasurementUnitHandler {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    public void createNewMeasurementUnit(List<MeasurementUnitDTO> measurementUnitDTOs){

        if(measurementUnitDTOs !=null){
            for(MeasurementUnitDTO measurementUnitDTO : measurementUnitDTOs){
                MeasurementUnit measurementUnit =  new MeasurementUnit();
                measurementUnit.setName(measurementUnitDTO.getName());
                measurementUnitRepository.save(measurementUnit);
            }
        }
    }
    
    public List<MeasurementUnitDTO> getAllMeasurementUnits(){
        Iterable<MeasurementUnit> units = measurementUnitRepository.findAll();
        List<MeasurementUnitDTO> result = new ArrayList<>();
        for(MeasurementUnit unit:units){
            result.add(new MeasurementUnitDTO(unit.getName()));
        }
        return result;
    }
    
    public MeasurementUnit getMeasurementUnitById(Long id){
        return measurementUnitRepository.findOne(id);
    }
}
