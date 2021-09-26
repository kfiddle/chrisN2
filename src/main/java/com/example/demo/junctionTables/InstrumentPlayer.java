package com.example.demo.junctionTables;


import com.example.demo.models.Instrument;
import com.example.demo.models.Player;

import javax.persistence.*;

@Entity
public class InstrumentPlayer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Instrument instrument;

    @ManyToOne
    private Player player;

    private int rank;

    public InstrumentPlayer() {}

    public InstrumentPlayer(Instrument instrument, Player player) {
        this.instrument = instrument;
        this.player = player;
    }

    public InstrumentPlayer(Instrument instrument, Player player, int rank) {
        this.instrument = instrument;
        this.player = player;
        this.rank = rank;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRank() {
        return rank;
    }
}



//    private Long instrumentId;
//    private Long playerId;
//    private int ranking;
//
//    public InstrumentPlayer() {}
//
//    public InstrumentPlayer(Long instrumentId, Long playerId) {
//        this.instrumentId = instrumentId;
//        this.playerId = playerId;
//    }
//
//    public void setInstrumentId(Long instrumentId) {
//        this.instrumentId = instrumentId;
//    }
//
//    public void setPlayerId(Long playerId) {
//        this.playerId = playerId;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Long getInstrumentId() {
//        return instrumentId;
//    }
//
//    public Long getPlayerId() {
//        return playerId;
//    }
//}
