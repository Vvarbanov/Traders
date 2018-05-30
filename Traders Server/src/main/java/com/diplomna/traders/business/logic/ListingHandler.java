package com.diplomna.traders.business.logic;

public class ListingHandler {
    
    
    
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
    
    public List<ItemDTO> getAllItems(){
        Iterable<Item> items = itemRepository.findAll();
        List<ItemDTO> result = new ArrayList<>();
        for(Item item:items){
            result.add(new ItemDTO(item.getName(), item.getDescription(), item.getBasePricePerUnit(), item.getUnit().getId(), item.getObject().getId()));
        }
        return result;
    }
    
    public Item getItemByID(Long id){
        return itemRepository.findOne(id);
    }
    
}
