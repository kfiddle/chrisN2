package com.example.demo.enums;

public enum Part {


    Piccolo("Piccolo"),
    Flute("Flute"),
    AltoFlute("Alto Flute"),
    Oboe("Oboe"),
    EnglishHorn("English Horn"),
    Clarinet("Clarinet"),
    EbClarinet("Eb Clarinet"),
    BassClarinet("Bass Clarinet"),
    Sax("Sax"),
    Bassoon("Bassoon"),
    Contra("Contra"),
    Horn("Horn"),
    Trumpet("Trumpet"),
    Trombone("Trombone"),
    BassTrombone("Bass Trombone"),
    Euphonium("Euphonium"),
    Tuba("Tuba"),
    Timpani("Timpani"),
    Percussion("Percussion"),
    Harp("Harp"),
    Piano("Piano"),
    Keyboard("Keyboard"),
    Violin1("Violin 1"),
    Violin2("Violin 2"),
    Viola("Viola"),
    Cello("Cello"),
    Bass("Bass");

    private final String stringVersion;

    Part(String stringVersion) {
        this.stringVersion = stringVersion;
    }

    public String toString() {
        return stringVersion;
    }

}
