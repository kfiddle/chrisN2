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
//
//    @OneToMany(mappedBy = "player")
//    Collection<InstrumentPlayer> instrumentPlayers;

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

    public Player() {
    }

    public Player(String firstNameArea, String lastName) {
        this.firstNameArea = firstNameArea;
        this.lastName = lastName;
    }

//    public Player(String firstNameArea, String lastName, Collection<InstrumentPlayer> instrumentPlayers) {
//        this.firstNameArea = firstNameArea;
//        this.lastName = lastName;
//        this.instrumentPlayers = instrumentPlayers;
//    }

//    public Player(Collection<InstrumentPlayer> instrumentPlayers, Type type, String firstNameArea, String lastName, String email, String homePhone, String cellPhone, String addressLine1, String addressLine2, String city, String state, String zip, String unions, int subRanking) {
//        this.instrumentPlayers = instrumentPlayers;
//        this.type = type;
//        this.firstNameArea = firstNameArea;
//        this.lastName = lastName;
//        this.email = email;
//        this.homePhone = homePhone;
//        this.cellPhone = cellPhone;
//        this.addressLine1 = addressLine1;
//        this.addressLine2 = addressLine2;
//        this.city = city;
//        this.state = state;
//        this.zip = zip;
//        this.unions = unions;
//        this.subRanking = subRanking;
//    }

//    public void setInstrumentPlayers(Collection<InstrumentPlayer> instrumentPlayers) {
//        this.instrumentPlayers = instrumentPlayers;
//    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setFirstNameArea(String firstNameArea) {
        this.firstNameArea = firstNameArea;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setUnions(String unions) {
        this.unions = unions;
    }

    public void setSubRanking(int subRanking) {
        this.subRanking = subRanking;
    }

    public Long getId() {
        return id;
    }

//    public Collection<InstrumentPlayer> getInstrumentPlayers() {
//        return instrumentPlayers;
//    }

    public Type getType() {
        return type;
    }

    public String getFirstNameArea() {
        return firstNameArea;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getUnions() {
        return unions;
    }

    public int getSubRanking() {
        return subRanking;
    }

    public void setAllProps(Player otherPlayer) {

        if (otherPlayer.getFirstNameArea() != null) {
            firstNameArea = otherPlayer.getFirstNameArea();
        }

        if (otherPlayer.getLastName() != null) {
            lastName = otherPlayer.getLastName();
        }

        if (otherPlayer.getEmail() != null) {
            email = otherPlayer.getEmail();
        }

        if (otherPlayer.getHomePhone() != null) {
            homePhone = otherPlayer.getHomePhone();
        }

        if (otherPlayer.getCellPhone() != null) {
            cellPhone = otherPlayer.getCellPhone();
        }

        if (otherPlayer.getAddressLine1() != null) {
            addressLine1 = otherPlayer.getAddressLine1();
        }

        if (otherPlayer.getAddressLine2() != null) {
            addressLine2 = otherPlayer.getAddressLine2();
        }

        if (otherPlayer.getCity() != null) {
            city = otherPlayer.getCity();
        }

        if (otherPlayer.getState() != null) {
            state = otherPlayer.getState();
        }

        if (otherPlayer.getZip() != null) {
            zip = otherPlayer.getZip();
        }

        if (otherPlayer.getType() != null) {
            type = otherPlayer.getType();
        }
    }

}
