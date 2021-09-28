package com.example.demo.enums;

public enum InstrumentEnum {

    VIOLIN1("Violin 1"),
    VIOLIN2("Violin 2"),
    VIOLA("Viola"),
    CELLO("Cello"),
    BASS("Bass"),
    FLUTE("Flute"),
    OBOE("Oboe"),
    CLARINET("Clarinet"),
    EBCLARINET("Eb Clarinet"),
    BASSOON("Bassoon"),
    HORN("Horn"),
    TRUMPET("Trumpet"),
    TROMBONE("Trombone"),
    TUBA("Tuba"),
    TIMPANI("Timpani"),
    PERCUSSION("Percussion"),
    HARP("Harp"),
    KEYBOARD("Keyboard"),
    PIANO("Piano");


    private final String stringVersion;

    InstrumentEnum(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public String toString() {
        return stringVersion;
    }
}
