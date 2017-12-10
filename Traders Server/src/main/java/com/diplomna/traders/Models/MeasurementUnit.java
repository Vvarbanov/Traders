package com.diplomna.traders.Models;

import javax.persistence.*;

@Entity
public class MeasurementUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "unit_name")
    private String name;

}
