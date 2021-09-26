package com.example.demo.models;


import com.example.demo.junctionTables.InstrumentPlayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Instrument {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "instrument")
//    Collection<InstrumentPlayer> instrumentPlayers;

    public Instrument() {
    }

    public Instrument(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

//    public void setInstrumentPlayers(Collection<InstrumentPlayer> instrumentPlayers) {
//        this.instrumentPlayers = instrumentPlayers;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public Collection<InstrumentPlayer> getInstrumentPlayers() {
//        return instrumentPlayers;
//    }
}
