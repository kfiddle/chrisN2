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

    @OneToMany
    Collection<InstrumentPlayer> instrumentPlayers;




}
