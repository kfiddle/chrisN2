package com.example.demo.models;


import com.example.demo.enums.EnumMainType;
import com.example.demo.enums.EnumSubType;

import javax.persistence.Embeddable;

@Embeddable
public class Type {

    private EnumMainType mainType;
    private EnumSubType subType;

    public Type(EnumMainType mainType, EnumSubType subType) {
        this.mainType = mainType;
        this.subType = subType;
    }

    public Type() {
    }

    public void setMainType(EnumMainType mainType) {
        this.mainType = mainType;
    }

    public void setSubType(EnumSubType subType) {
        this.subType = subType;
    }

    public EnumMainType getMainType() {
        return mainType;
    }

    public EnumSubType getSubType() {
        return subType;
    }
}
