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

    @Column(name = "category_level")
    private int level;

    @ManyToMany
    private List<Item> items = new ArrayList<>();

    public Category(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public Category() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
