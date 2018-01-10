package com.diplomna.traders.Models;

import javax.persistence.*;

@Entity
public class TV {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "color")
    private String color;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "screen_technology")
    private String screenTechnology;

    @Column(name = "refresh_rate")
    private int refreshRate;

    @Column(name = "warranty")
    private int warranty;

    @Column(name = "three_dimensional_image")
    private boolean threeDimensionalImage;

    @Column(name = "wifi")
    private boolean wifi;

    public TV(String model, String brand, String screenSize, String color, String resolution, String screenTechnology, int refreshRate, int warranty, boolean threeDimensionalImage, boolean wifi) {
        this.model = model;
        this.brand = brand;
        this.screenSize = screenSize;
        this.color = color;
        this.resolution = resolution;
        this.screenTechnology = screenTechnology;
        this.refreshRate = refreshRate;
        this.warranty = warranty;
        this.threeDimensionalImage = threeDimensionalImage;
        this.wifi = wifi;
    }

    public TV() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public void setScreenTechnology(String screenTechnology) {
        this.screenTechnology = screenTechnology;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public boolean isThreeDimensionalImage() {
        return threeDimensionalImage;
    }

    public void setThreeDimensionalImage(boolean threeDimensionalImage) {
        this.threeDimensionalImage = threeDimensionalImage;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
