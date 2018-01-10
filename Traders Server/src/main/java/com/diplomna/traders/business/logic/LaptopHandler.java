package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.ItemDTO;
import com.diplomna.traders.DTOs.LaptopDTO;
import com.diplomna.traders.Models.Item;
import com.diplomna.traders.Models.Laptop;
import com.diplomna.traders.Models.MeasurementUnit;
import com.diplomna.traders.repository.ItemRepository;
import com.diplomna.traders.repository.LaptopRepository;
import com.diplomna.traders.repository.MeasurementUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LaptopHandler {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    public void createNewLaptop(List<LaptopDTO> laptopDTOS){

        if(laptopDTOS != null) {
            for (LaptopDTO laptopDTO:laptopDTOS) {
                Laptop laptop = new Laptop();
                laptop.setModel(laptopDTO.getModel());
                laptop.setBrand(laptopDTO.getBrand());
                laptop.setColor(laptopDTO.getColor());
                laptop.setRefreshRate(laptopDTO.getRefreshRate());
                laptop.setResolution(laptopDTO.getResolution());
                laptop.setScreenSize(laptopDTO.getScreenSize());
                laptop.setScreenTechnology(laptopDTO.getScreenTechnology());
                laptop.setCpu(laptopDTO.getCpu());
                laptop.setGpu(laptopDTO.getGpu());
                laptop.setRam(laptopDTO.getRam());
                laptop.setWarranty(laptopDTO.getWarranty());
                laptop.setThreeDimensionalImage(laptopDTO.isThreeDimensionalImage());
                laptop.setWifi(laptopDTO.isWifi());

                laptopRepository.save(laptop);
            }
        }
    }
    public Iterable<Laptop> getAllLaptop(){
        return laptopRepository.findAll();
    }
}
