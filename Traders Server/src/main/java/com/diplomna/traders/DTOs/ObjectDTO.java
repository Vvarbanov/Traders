package com.diplomna.traders.dtos;


import com.diplomna.traders.models.MyObject;
import com.diplomna.traders.models.MyProperties;

import java.util.ArrayList;
import java.util.List;

public class ObjectDto {

    private String objectName;
    private List<PropertiesDto> props = new ArrayList<>();
    public String getObjectName() {
        return objectName;
    }

    public ObjectDto(MyObject obj){
        this.objectName=obj.getObjectName();
        for(MyProperties myProp:obj.getProperties()){
            this.props.add(new PropertiesDto(myProp));
        }
    }

    public ObjectDto(){}

    public List<PropertiesDto> getProps() {
        return props;
    }

    public void setProps(List<PropertiesDto> props) {
        this.props = props;
    }
}
