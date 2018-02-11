package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.ObjectDto;
import com.diplomna.traders.models.MyObject;
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

    public void createNewObject(List<ObjectDto> objectDtos){
        
        if(objectDtos !=null){
            for(ObjectDto objectDto : objectDtos){
                MyObject myObject = new MyObject();
                myObject.setObjectName(objectDto.getObjectName());
                objectRepository.save(myObject);
            }
        }
    }

    public List<ObjectDto> getAllObjects(){
        Iterable<MyObject> myObjects = objectRepository.findAll();
        List<ObjectDto> result = new ArrayList<>();
        for(MyObject obj:myObjects){
            result.add(new ObjectDto(obj));
        }
        return result;
    }
}
