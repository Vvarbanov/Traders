package com.diplomna.traders.dtos;

import com.diplomna.traders.models.MyProperties;

public class PropertiesDto {

    private String propertyName;
    private String value;
    private long objectId;

    public PropertiesDto(MyProperties myProp) {
        this.propertyName=myProp.getPropertyName();
        this.value=myProp.getValue();
    }

    public PropertiesDto(){}

    public String getPropertyName() {
        return propertyName;
    }

    public String getValue() {
        return value;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
