package com.diplomna.traders.DTOs;

public class CategoryDTO {

    private String name;
    private int level;

    public CategoryDTO(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public CategoryDTO() {}

    public String getName() {
        return name;
    }

    public int getLevel() {
       return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
