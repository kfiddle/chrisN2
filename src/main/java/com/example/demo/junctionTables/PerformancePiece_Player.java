package com.example.demo.junctionTables;


import com.example.demo.enums.Chair;
import com.example.demo.enums.InstrumentEnum;
import com.example.demo.models.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.CollationElementIterator;
import java.util.Collection;

@Entity
public class PerformancePiece_Player {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private PerformancePiece performancePiece;

    @ManyToOne
    private Player player;

    private Chair chair;



    private InstrumentEnum instrumentEnum;



    public PerformancePiece_Player() {
    }

    public PerformancePiece_Player(PerformancePiece performancePiece) {
        this.performancePiece = performancePiece;
    }

    public PerformancePiece_Player(PerformancePiece performancePiece, InstrumentEnum instrumentEnum) {
        this.performancePiece = performancePiece;
        this.instrumentEnum = instrumentEnum;
    }




    public PerformancePiece_Player(PerformancePiece performancePiece, Player player) {
        this.performancePiece = performancePiece;
        this.player = player;
    }

    public PerformancePiece_Player(PerformancePiece performancePiece, Player player, Chair chair, InstrumentEnum instrumentEnum) {
        this.performancePiece = performancePiece;
        this.player = player;
        this.chair = chair;
        this.instrumentEnum = instrumentEnum;
    }

    public void setPerformancePiece(PerformancePiece performancePiece) {
        this.performancePiece = performancePiece;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public void setInstrumentEnum(InstrumentEnum instrumentEnum) {
        this.instrumentEnum = instrumentEnum;
    }

    public Long getId() {
        return id;
    }

    public PerformancePiece getPerformancePiece() {
        return performancePiece;
    }

    public Player getPlayer() {
        return player;
    }

    public Chair getChair() {
        return chair;
    }

    public InstrumentEnum getInstrumentEnum() {
        return instrumentEnum;
    }
}
