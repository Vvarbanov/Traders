package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.PropertiesDTO;
import com.diplomna.traders.Models.MyObject;
import com.diplomna.traders.Models.MyProperties;
import com.diplomna.traders.repository.ObjectRepository;
import com.diplomna.traders.repository.PropertiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropertiesHandler {

    @Autowired
    private PropertiesRepository propertiesRepository;

    @Autowired
    private ObjectRepository objectRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void createNewProperty(List<PropertiesDTO> propertiesDTOS){
        if(propertiesDTOS!=null){
            for(PropertiesDTO propertiesDTO:propertiesDTOS){
                MyProperties newProperty = new MyProperties();
                newProperty.setPropertyName(propertiesDTO.getPropertyName());
                newProperty.setValue(propertiesDTO.getValue());
                MyObject myObject = objectRepository.findOne(propertiesDTO.getObjectId());
                logger.debug("logging "+myObject.getObjectName());
                newProperty.getMyObjects().add(myObject);
                myObject.getProperties().add(newProperty);
                propertiesRepository.save(newProperty);
                objectRepository.save(myObject);
            }
        }
    }
}
