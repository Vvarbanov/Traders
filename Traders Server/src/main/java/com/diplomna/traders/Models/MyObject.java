package com.diplomna.traders.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MyObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "object_name")
    private String objectName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MyProperties> properties = new ArrayList<>();

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public MyObject(String objectName) {
        this.objectName = objectName;
    }

    public MyObject() {}

    public List<MyProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<MyProperties> properties) {
        this.properties = properties;
    }

    public long getId() {
        return id;
    }


}
