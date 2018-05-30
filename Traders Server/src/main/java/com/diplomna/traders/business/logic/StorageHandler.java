package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.StorageDTO;
import com.diplomna.traders.models.Item;
import com.diplomna.traders.models.Storage;
import com.diplomna.traders.models.User;
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
