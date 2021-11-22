package com.example.demo.junctionTables;

import com.example.demo.enums.Part;
import com.example.demo.models.Player;

import javax.persistence.ManyToOne;

public class ChairBuilder {

    Part part;
    int rank;
    Player player;

    public ChairBuilder() {
    }

    public ChairBuilder(Part part) {
        this.part = part;
    }

    public ChairBuilder(int rank) {
        this.rank = rank;
    }

    public ChairBuilder(Player player) {
        this.player = player;
    }

    public PInChair build() {
        return new PInChair(this);
    }
}
