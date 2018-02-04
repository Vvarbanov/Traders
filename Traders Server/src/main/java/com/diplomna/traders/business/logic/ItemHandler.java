package com.diplomna.traders.business.logic;

import com.diplomna.traders.DTOs.ItemDTO;
import com.diplomna.traders.Models.Item;
import com.diplomna.traders.Models.MeasurementUnit;
import com.diplomna.traders.Models.MyObject;
import com.diplomna.traders.repository.ItemRepository;
import com.diplomna.traders.repository.MeasurementUnitRepository;
import com.diplomna.traders.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemHandler {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    @Autowired
    private ObjectRepository objectRepository;

    public void createNewItem(List<ItemDTO> newItems){

        if(newItems != null) {
            for (ItemDTO newItem:newItems) {
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
}
