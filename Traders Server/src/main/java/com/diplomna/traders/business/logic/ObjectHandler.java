package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.ObjectDTO;
import com.diplomna.traders.Models.MyObject;
import com.diplomna.traders.repository.ObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ObjectHandler {

    @Autowired
    private ObjectRepository objectRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void createNewObject(List<ObjectDTO> objectDTOS){

        if(objectDTOS!=null){
            for(ObjectDTO objectDTO:objectDTOS){
                MyObject myObject = new MyObject();
                myObject.setObjectName(objectDTO.getObjectName());
                objectRepository.save(myObject);
            }
        }
    }

    public List<ObjectDTO> getAllObjects(){
        Iterable<MyObject> myObjs=objectRepository.findAll();
        logger.debug(myObjs.iterator().next().getProperties().get(0).getPropertyName());
        List<ObjectDTO> result = new ArrayList<>();
        for(MyObject obj:myObjs){
            result.add(new ObjectDTO(obj));
        }
        return result;
    }
}
