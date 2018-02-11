package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.MeasurementUnitDto;
import com.diplomna.traders.models.MeasurementUnit;
import com.diplomna.traders.repository.MeasurementUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeasurementUnitHandler {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    public void createNewMeasurementUnit(List<MeasurementUnitDto> measurementUnitDtos){

        if(measurementUnitDtos !=null){
            for(MeasurementUnitDto measurementUnitDto: measurementUnitDtos){
                MeasurementUnit measurementUnit =  new MeasurementUnit();
                measurementUnit.setName(measurementUnitDto.getName());
                measurementUnitRepository.save(measurementUnit);
            }
        }
    }
    
    public List<MeasurementUnitDto> getAllMeasurementUnits(){
        Iterable<MeasurementUnit> units = measurementUnitRepository.findAll();
        List<MeasurementUnitDto> result = new ArrayList<>();
        for(MeasurementUnit unit:units){
            result.add(new MeasurementUnitDto(unit.getName()));
        }
        return result;
    }
    
    public MeasurementUnit getMeasurementUnitById(Long id){
        return measurementUnitRepository.findOne(id);
    }
}
