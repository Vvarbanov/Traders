package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.ListingDTO;
import com.diplomna.traders.models.Listing;
import com.diplomna.traders.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListingHandler {
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private StorageRepository storageRepository;
    
    @Autowired
    private ListingRepository listingRepository;
    
    public void createNewListing(List<ListingDTO> newListings) {
    
        public List<ListingDTO> getAllListings () {
            Iterable<Listing> listings = listingRepository.findAll();
            List<ListingDTO> result = new ArrayList<>();
            for (Listing listing : listings) {
                result =
            }
            return result;
        }
    }
}