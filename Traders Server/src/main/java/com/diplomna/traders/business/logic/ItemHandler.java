package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.ItemDto;
import com.diplomna.traders.models.Item;
import com.diplomna.traders.models.MeasurementUnit;
import com.diplomna.traders.models.MyObject;
import com.diplomna.traders.repository.ItemRepository;
import com.diplomna.traders.repository.MeasurementUnitRepository;
import com.diplomna.traders.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemHandler {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    @Autowired
    private ObjectRepository objectRepository;

    public void createNewItem(List<ItemDto> newItems){

        if(newItems != null) {
            for (ItemDto newItem:newItems) {
                MeasurementUnit unit = measurementUnitRepository.findOne(newItem.getUnit());
                MyObject object = objectRepository.findOne(newItem.getObject());

                Item item = new Item();
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setBasePricePerUnit(newItem.getBasePricePerUnit());
                item.setUnit(unit);
                item.setObject(object);

                itemRepository.save(item);
            }
        }
    }
    
    public List<ItemDto> getAllItems(){
        Iterable<Item> items = itemRepository.findAll();
        List<ItemDto> result = new ArrayList<>();
        for(Item item:items){
            result.add(new ItemDto(item.getName(), item.getDescription(), item.getBasePricePerUnit(), item.getUnit().getId(), item.getObject().getId()));
        }
        return result;
    }
    
    public Item getItemByID(Long id){
        return itemRepository.findOne(id);
    }
}
