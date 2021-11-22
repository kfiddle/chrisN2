package com.example.demo.enums;

public enum Part {

    Piccolo("Piccolo", 1),
    Flute("Flute", 2),
    AltoFlute("Alto Flute", 3),
    Oboe("Oboe", 4),
    EnglishHorn("English Horn", 5),
    Clarinet("Clarinet", 6),
    EbClarinet("Eb Clarinet", 7),
    BassClarinet("Bass Clarinet", 8),
    Sax("Sax", 9),
    Bassoon("Bassoon", 10),
    Contra("Contra", 11),
    Horn("Horn", 12),
    Trumpet("Trumpet", 13),
    Trombone("Trombone", 14),
    BassTrombone("Bass Trombone", 15),
    Euphonium("Euphonium", 16),
    Tuba("Tuba", 17),
    Timpani("Timpani", 18),
    Percussion("Percussion", 19),
    Harp("Harp", 20),
    Piano("Piano", 21),
    Keyboard("Keyboard", 22),
    Violin1("Violin1", 23),
    Violin2("Violin2", 24),
    Viola("Viola", 25),
    Cello("Cello", 26),
    Bass("Bass", 27);

    private final String stringVersion;
    private final int scoreOrder;

    Part(String stringVersion, int scoreOrder) {
        this.stringVersion = stringVersion;
        this.scoreOrder = scoreOrder;
    }

    public String toString() {
        return stringVersion;
    }

    public int getScoreOrder() {
        return scoreOrder;
    }


    public int compare(Part otherPart) {
        return Integer.compare(scoreOrder, otherPart.getScoreOrder());
    }

    static public Part ofPartName(String partName) {
        for (Part part : Part.values()) {
            if (part.toString().equals(partName)) {
                return part;
            }
        }
        throw new IllegalArgumentException("No such part name as: " + partName);
    }

}




