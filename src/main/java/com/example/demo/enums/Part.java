package com.example.demo.enums;

public enum Part {


    PICCOLO("Piccolo"),
    FLUTE("Flute"),
    ALTOFLUTE("Alto Flute"),
    OBOE("Oboe"),
    ENGLISHHORN("English Horn"),
    CLARINET("Clarinet"),
    EBCLARINET("Eb Clarinet"),
    BASSCLARINET("Bass Clarinet"),
    SAX("Sax"),
    BASSOON("Bassoon"),
    CONTRA("Contra"),
    HORN("Horn"),
    TRUMPET("Trumpet"),
    TROMBONE("Trombone"),
    BASSTROMBONE("Bass Trombone"),
    EUPHONIUM("Euphonium"),
    TUBA("Tuba"),
    TIMPANI("Timpani"),
    PERCUSSION("Percussion"),
    HARP("Harp"),
    PIANO("Piano"),
    KEYBOARD("Keyboard"),
    VIOLIN1("Violin 1"),
    VIOLIN2("Violin 2"),
    VIOLA("Viola"),
    CELLO("Cello"),
    BASS("Bass");

    private final String stringVersion;

    Part(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public String toString() {
        return stringVersion;
    }

}
