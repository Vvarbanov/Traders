package com.diplomna.traders.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "category_name")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    private List<Item> items = new ArrayList<>();

}
