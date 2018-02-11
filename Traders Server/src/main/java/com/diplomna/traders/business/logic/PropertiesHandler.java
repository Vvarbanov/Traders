package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.PropertiesDto;
import com.diplomna.traders.models.MyObject;
import com.diplomna.traders.models.MyProperties;
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

    public void createNewProperty(List<PropertiesDto> propertiesDtos){
        if(propertiesDtos !=null){
            for(PropertiesDto propertiesDto : propertiesDtos){
                MyProperties newProperty = new MyProperties();
                newProperty.setPropertyName(propertiesDto.getPropertyName());
                newProperty.setValue(propertiesDto.getValue());
                MyObject myObject = objectRepository.findOne(propertiesDto.getObjectId());
                //logger.debug("logging "+myObject.getObjectName());
                newProperty.getMyObjects().add(myObject);
                myObject.getProperties().add(newProperty);
                propertiesRepository.save(newProperty);
                objectRepository.save(myObject);
            }
        }
    }
}
