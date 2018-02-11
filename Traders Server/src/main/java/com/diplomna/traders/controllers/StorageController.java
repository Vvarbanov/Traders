package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.StorageDto;
import com.diplomna.traders.business.logic.StorageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/storage")
@RestController
public class StorageController {
    
    @Autowired
    private StorageHandler storageHandler;
    
    @RequestMapping("/create")
    public ResponseEntity<List<StorageDto>> createStorage(@RequestBody List<StorageDto> storageDtos){
        
        storageHandler.createNewStorage(storageDtos);
        
        return ResponseEntity.ok(storageDtos);
    }

}
