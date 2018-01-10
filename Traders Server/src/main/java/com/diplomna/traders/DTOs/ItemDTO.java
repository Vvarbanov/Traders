package com.diplomna.traders.DTOs;

import java.util.List;

public class ItemDTO {

    private String name;
    private String description;
    private double basePricePerUnit;
    private Long unit;

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
}
