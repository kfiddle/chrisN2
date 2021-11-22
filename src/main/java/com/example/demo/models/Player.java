package com.example.demo.models;


import com.example.demo.enums.EnumSubType;
import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.junctionTables.InstrumentPlayer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Player implements Comparable<Player> {

    @Id
    @GeneratedValue
    private Long id;

    private Type type;

    @ElementCollection
    private List<Part> parts;

    private String firstNameArea;
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private Set<InstrumentPlayer> instruments;

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

    private boolean hasContract;

    @OneToOne
    private Contract contract;

    public Player() {
    }

    public Player(String firstNameArea, String lastName) {
        this.firstNameArea = firstNameArea;
        this.lastName = lastName;
        parts = new ArrayList<>();
    }

    public void setFirstNameArea(String firstNameArea) {
        this.firstNameArea = firstNameArea;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
        hasContract = true;
    }

    public void setType(Type type) {
        this.type = type;
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

    public String getFirstNameArea() {
        return firstNameArea;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Part> getParts() {
        return parts;
    }

    public Set<InstrumentPlayer> getInstruments() {
        return instruments;
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

    public boolean hasContract() {
        return hasContract;
    }

    public Contract getContract() {
        return contract;
    }

    public Type getType() {
        return type;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public void setAllProps(Player otherPlayer) {

        if (otherPlayer.getFirstNameArea() != null) {
            firstNameArea = otherPlayer.getFirstNameArea();
        }

        if (otherPlayer.getLastName() != null) {
            lastName = otherPlayer.getLastName();
        }
        if (otherPlayer.getParts() != null) {
            parts = otherPlayer.getParts();
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


        if (otherPlayer.hasContract()) {
            contract = otherPlayer.getContract();
        }
        if (otherPlayer.getSubRanking() > 0) {
            subRanking = otherPlayer.getSubRanking();
        }
    }

    @Override
    public int compareTo(Player otherPlayer) {
        return contract.compareTo(otherPlayer.getContract());
    }
}



