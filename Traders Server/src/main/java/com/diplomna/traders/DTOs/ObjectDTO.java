package com.diplomna.traders.dtos;


import com.diplomna.traders.models.MyObject;
import com.diplomna.traders.models.MyProperties;

import java.util.ArrayList;
import java.util.List;

public class ObjectDTO {

    private String objectName;
    private List<PropertiesDTO> props = new ArrayList<>();
    public String getObjectName() {
        return objectName;
    }

    public ObjectDTO(MyObject obj){
        this.objectName=obj.getObjectName();
        for(MyProperties myProp:obj.getProperties()){
            this.props.add(new PropertiesDTO(myProp));
        }
    }

    public ObjectDTO(){}

    public List<PropertiesDTO> getProps() {
        return props;
    }

    public void setProps(List<PropertiesDTO> props) {
        this.props = props;
    }
}
