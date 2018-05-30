package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.ObjectDTO;
import com.diplomna.traders.models.MyObject;
import com.diplomna.traders.repository.ObjectRepository;
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
