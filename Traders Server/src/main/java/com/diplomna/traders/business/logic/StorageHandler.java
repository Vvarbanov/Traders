package com.diplomna.traders.business.Logic;

import com.diplomna.traders.DTOs.StorageDTO;
import com.diplomna.traders.Models.Item;
import com.diplomna.traders.Models.Storage;
import com.diplomna.traders.Models.User;
import com.diplomna.traders.Repository.ItemRepository;
import com.diplomna.traders.Repository.StorageRepository;
import com.diplomna.traders.Repository.UserRepository;
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
    
    public void createNewStorage(List<StorageDTO> storageDTOs){
        
        if(storageDTOs !=null){
            for(StorageDTO storageDTO : storageDTOs){
    
                Storage storage = new Storage();
                Item item = itemRepository.findOne(storageDTO.getItem());
                User dealer = userRepository.findOne(storageDTO.getDealer());
    
                storage.setImage(storageDTO.getImage());
                storage.setPriceMultiplier(storageDTO.getPriceMultiplier());
                storage.setQrHash(storageDTO.getQRHash());
                storage.setQuantity(storageDTO.getQuantity());
                storage.setItem(item);
                storage.setDealer(dealer);
                storageRepository.save(storage);
            }
        }
    }

}
