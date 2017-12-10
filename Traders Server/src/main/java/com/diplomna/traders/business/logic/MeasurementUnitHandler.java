package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.MeasurementUnitDTO;
import com.diplomna.traders.Models.MeasurementUnit;
import com.diplomna.traders.repository.MeasurementUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeasurementUnitHandler {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    public void createNewMeasurementUnit(List<MeasurementUnitDTO> measurementUnitDTOs){

        if(measurementUnitDTOs!=null){
            for(MeasurementUnitDTO measurementUnitDto:measurementUnitDTOs){
                MeasurementUnit measurementUnit =  new MeasurementUnit();
                measurementUnit.setName(measurementUnitDto.getName());
                measurementUnitRepository.save(measurementUnit);
            }
        }




    }

}
