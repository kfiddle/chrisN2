package com.example.demo.models;


import com.example.demo.enums.Type;
import com.example.demo.junctionTables.InstrumentPlayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    Collection<InstrumentPlayer> instrumentPlayers;

    private Type type;

    private String firstNameArea;
    private String lastName;

    private String email;
    private String homePhone;
    private String cellPhone;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

    private String unions;
    private int subRanking;

    public Player() {}



}
