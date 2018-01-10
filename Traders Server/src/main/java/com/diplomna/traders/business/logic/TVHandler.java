package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.TVDTO;
import com.diplomna.traders.Models.TV;
import com.diplomna.traders.repository.TVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TVHandler {

    @Autowired
    private TVRepository tvRepository;

    public void createNewTV(List<TVDTO> tvDTOs){

        if(tvDTOs!=null){
            for(TVDTO tvdto:tvDTOs){
                TV tv =  new TV();
                tv.setModel(tvdto.getModel());
                tv.setBrand(tvdto.getBrand());
                tv.setColor(tvdto.getColor());
                tv.setRefreshRate(tvdto.getRefreshRate());
                tv.setResolution(tvdto.getResolution());
                tv.setScreenSize(tvdto.getScreenSize());
                tv.setScreenTechnology(tvdto.getScreenTechnology());
                tv.setWarranty(tvdto.getWarranty());
                tv.setThreeDimensionalImage(tvdto.isThreeDimensionalImage());
                tv.setWifi(tvdto.isWifi());
                tvRepository.save(tv);
            }
        }
    }

    public Iterable<TV> getAllTV(){
        return tvRepository.findAll();
    }
}
