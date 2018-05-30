package com.diplomna.traders.models;

import javax.persistence.*;

@Entity
public class MeasurementUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "unit_name")
    private String name;

    public MeasurementUnit(String name) {
        this.name = name;
    }

    public MeasurementUnit() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
}
