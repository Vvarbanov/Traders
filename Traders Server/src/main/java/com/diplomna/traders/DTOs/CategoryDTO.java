package com.diplomna.traders.dtos;

public class CategoryDto {

    private String name;
    private int level;

    public CategoryDto(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public CategoryDto() {}

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
