package com.diplomna.traders.Controllers;

import com.diplomna.traders.DTOs.StorageDTO;
import com.diplomna.traders.business.Logic.StorageHandler;
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
    public ResponseEntity<List<StorageDTO>> createStorage(@RequestBody List<StorageDTO> storageDTOs){
        
        storageHandler.createNewStorage(storageDTOs);
        
        return ResponseEntity.ok(storageDTOs);
    }

}
