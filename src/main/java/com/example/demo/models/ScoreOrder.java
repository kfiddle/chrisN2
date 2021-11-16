package com.example.demo.models;

import java.util.ArrayList;
import java.util.Arrays;

public interface ScoreOrder {

    public final ArrayList<String> scoreOrder = new ArrayList<>(Arrays.asList("Piccolo", "Flute", "Alto Flute", "Oboe", "English Horn", "Clarinet", "Eb Clarinet", "Bass Clarinet", "Sax",
            "Bassoon", "Contra", "Horn", "Trumpet", "Trombone", "Bass Trombone", "Euphonium", "Tuba", "Timpani", "Percussion",
            "Harp", "Piano", "Keyboard", "Violin 1", "Violin 2", "Viola", "Cello", "Bass"));

    public default int getOrder(String part) {
        return scoreOrder.indexOf(part);
    }

}
