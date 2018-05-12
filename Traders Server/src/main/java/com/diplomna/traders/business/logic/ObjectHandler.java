package com.diplomna.traders.business.Logic;

import com.diplomna.traders.DTOs.ObjectDTO;
import com.diplomna.traders.Models.MyObject;
import com.diplomna.traders.Repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectHandler {

    @Autowired
    private ObjectRepository objectRepository;

    public void createNewObject(List<ObjectDTO> objectDTOs){
        
        if(objectDTOs !=null){
            for(ObjectDTO objectDTO : objectDTOs){
                MyObject myObject = new MyObject();
                myObject.setObjectName(objectDTO.getObjectName());
                objectRepository.save(myObject);
            }
        }
    }

    public List<ObjectDTO> getAllObjects(){
        Iterable<MyObject> myObjects = objectRepository.findAll();
        List<ObjectDTO> result = new ArrayList<>();
        for(MyObject obj:myObjects){
            result.add(new ObjectDTO(obj));
        }
        return result;
    }
}
