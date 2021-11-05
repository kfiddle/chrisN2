package com.example.demo.enums;

public enum EnumSubType {

    A("B"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private final String stringVersion;

    EnumSubType(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public String toString() {
        return stringVersion;
    }


}
