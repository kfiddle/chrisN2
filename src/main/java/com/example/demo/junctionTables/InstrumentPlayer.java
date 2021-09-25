package com.example.demo.junctionTables;


import com.example.demo.models.Instrument;
import com.example.demo.models.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InstrumentPlayer {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Instrument instrument;

    @OneToOne
    private Player player;

    public InstrumentPlayer() {}

    public InstrumentPlayer(Instrument instrument, Player player) {
        this.instrument = instrument;
        this.player = player;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
}
//    private Long instrumentId;
//    private Long playerId;
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
