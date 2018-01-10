package com.diplomna.traders.DTOs;

public class LaptopDTO {

    private String model;
    private String brand;
    private String screenSize;
    private String color;
    private String resolution;
    private String screenTechnology;
    private String cpu;
    private String gpu;
    private int ram;
    private int refreshRate;
    private int warranty;
    private boolean threeDimensionalImage;
    private boolean wifi;

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public String getColor() {
        return color;
    }

    public String getResolution() {
        return resolution;
    }

    public String getScreenTechnology() {
        return screenTechnology;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public int getRam() {
        return ram;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public int getWarranty() {
        return warranty;
    }

    public boolean isThreeDimensionalImage() {
        return threeDimensionalImage;
    }

    public boolean isWifi() {
        return wifi;
    }
}
