package com.diplomna.traders.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MyProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "property_name")
    private String propertyName;

    @Column(name = "value")
    private String value;



    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    public MyProperties(String propertyName, String value, long objectId) {
        this.propertyName = propertyName;
        this.value = value;

    }

    public MyProperties() {}

    @ManyToMany(mappedBy = "properties",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<MyObject> myObjects = new ArrayList<>();

    public List<MyObject> getMyObjects() {
        return myObjects;
    }

    public void setMyObjects(List<MyObject> myObjects) {
        this.myObjects = myObjects;
    }

    public long getId() {
        return id;
    }


}
