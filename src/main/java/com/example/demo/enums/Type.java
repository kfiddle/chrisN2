package com.example.demo.enums;

public enum Type {
    CONTRACT("Contract"),
    SUB("Sub");

    private final String stringVersion;

    Type(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public String toString() {
        return stringVersion;
    }
}
