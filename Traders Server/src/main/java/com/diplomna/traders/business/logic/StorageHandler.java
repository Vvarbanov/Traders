package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.StorageDTO;
import com.diplomna.traders.Models.Item;
import com.diplomna.traders.Models.Storage;
import com.diplomna.traders.Models.User;
import com.diplomna.traders.repository.ItemRepository;
import com.diplomna.traders.repository.StorageRepository;
import com.diplomna.traders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StorageHandler {
    
    @Autowired
    private StorageRepository storageRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public void createNewStorage(List<StorageDTO> storageDTOS){
        
        if(storageDTOS!=null){
            for(StorageDTO storageDTO:storageDTOS){
    
                Storage storage = new Storage();
                Item item = itemRepository.findOne(storageDTO.getItem());
                User dealer = userRepository.findOne(storageDTO.getDealer());
    
                storage.setImage(storageDTO.getImage());
                storage.setPriceMultiplier(storageDTO.getPriceMultiplier());
                storage.setQRHash(storageDTO.getQRHash());
                storage.setQuantity(storageDTO.getQuantity());
                storage.setItem(item);
                storage.setDealer(dealer);
                storageRepository.save(storage);
            }
        }
    }

}
