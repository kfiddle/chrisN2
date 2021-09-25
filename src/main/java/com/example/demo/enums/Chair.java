package com.example.demo.enums;

public enum Chair {
    PRINC("Principal"),
    ASSOC("Associate"),
    TWO("2"),
    TWO_A("2A"),
    THREE("3"),
    THREE_A("3A"),
    FOUR("4"),
    FOUR_A("4A"),
    FIVE("5"),
    FIVE_A("5A"),
    SIX("6"),
    SEVEN("7"),
    SIX_A("6A"),
    PIC3("3/pic"),
    EH3("3eh"),
    BCL3("3/bcl");

    private final String stringVersion;

    Chair(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public String toString() {
        return stringVersion;
    }
    }
