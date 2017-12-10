package com.diplomna.traders.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_base_price_per_unit")
    private double basePricePerUnit;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    @OneToOne
    @PrimaryKeyJoinColumn
    private MeasurementUnit unit;

    public Item() {}

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

    public MeasurementUnit getUnit() {
        return unit;
    }

    public Item(String name, double basePricePerUnit, MeasurementUnit unit) {
        this.name = name;
        this.basePricePerUnit = basePricePerUnit;
        this.unit = unit;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }
}
