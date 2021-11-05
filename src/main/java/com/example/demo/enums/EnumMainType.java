package com.example.demo.enums;

public enum EnumMainType {

    CONTRACT("Contract"),
    SUB("Sub");

    private final String stringVersion;

    EnumMainType(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public String toString() {
        return this.stringVersion;
    }

}
