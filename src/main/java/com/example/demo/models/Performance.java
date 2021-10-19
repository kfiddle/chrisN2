package com.example.demo.models;


import com.example.demo.junctionTables.PerformancePiece;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
public class Performance {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany
    private List<DateTime> dateTimes;

    private int numberOfServices;

    @OneToMany
    private Collection<PerformancePiece> performancePieces;

    public Performance() {
    }

    public Performance(String title) {
        this.title = title;
    }

//    public Performance(String title, Collection<DateTime> dateTimes) {
//        this.title = title;
//        this.dateTimes = dateTimes;
//    }

    public Performance(String title, DateTime... dateTimes) {
        this.title = title;
        this.dateTimes = Arrays.asList(dateTimes);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumberOfServices(int numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

    public void setPerformancePieces(Collection<PerformancePiece> performancePieces) {
        this.performancePieces = performancePieces;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Collection<DateTime> getDateTimes() {
        return dateTimes;
    }

    public DateTime getPrimaryDate() {
        return dateTimes.get(0);
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public Collection<PerformancePiece> getPerformancePieces() {
        return performancePieces;
    }
}

