package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.StorageDto;
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
    
    public void createNewStorage(List<StorageDto> storageDtos){
        
        if(storageDtos !=null){
            for(StorageDto storageDto : storageDtos){
    
                Storage storage = new Storage();
                Item item = itemRepository.findOne(storageDto.getItem());
                User dealer = userRepository.findOne(storageDto.getDealer());
    
                storage.setImage(storageDto.getImage());
                storage.setPriceMultiplier(storageDto.getPriceMultiplier());
                storage.setQRHash(storageDto.getQRHash());
                storage.setQuantity(storageDto.getQuantity());
                storage.setItem(item);
                storage.setDealer(dealer);
                storageRepository.save(storage);
            }
        }
    }

}
