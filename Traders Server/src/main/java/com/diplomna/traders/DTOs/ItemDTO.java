package com.diplomna.traders.DTOs;

import java.util.List;

public class ItemDTO {

    private String name;
    private double basePricePerUnit;
    private Long unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePricePerUnit() {
        return basePricePerUnit;
    }

    public void setBasePricePerUnit(double basePricePerUnit) {
        this.basePricePerUnit = basePricePerUnit;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }
}
