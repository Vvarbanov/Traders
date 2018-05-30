package com.diplomna.traders.dtos;

public class ItemDTO {

    private String name;
    private String description;
    private double basePricePerUnit;
    private Long unit;
    private Long object;

    public ItemDTO(String name, String description, double basePricePerUnit, Long unit, Long object) {
        this.name = name;
        this.description = description;
        this.basePricePerUnit = basePricePerUnit;
        this.unit = unit;
        this.object = object;
    }

    public ItemDTO() { }

    public String getName() {
        return name;
    }

    public double getBasePricePerUnit() {
        return basePricePerUnit;
    }

    public Long getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public Long getObject() {
        return object;
    }
}
