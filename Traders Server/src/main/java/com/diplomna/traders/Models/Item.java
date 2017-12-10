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

    @ManyToMany(mappedBy="items")
    private List<Category> categories= new ArrayList<>();

}
