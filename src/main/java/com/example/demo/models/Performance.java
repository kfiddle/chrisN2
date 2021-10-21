package com.example.demo.models;


import com.example.demo.junctionTables.PerformancePiece;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Performance implements Comparable<Performance> {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ElementCollection
    private List<DateTime> performanceDateTimes;

    @ElementCollection
    private List<DateTime> rehearsalDateTimes;

    private int numberOfServices;

    @OneToMany
    private Collection<PerformancePiece> performancePieces;

    public Performance() {
    }

    public Performance(String title) {
        this.title = title;
    }

    public Performance(String title, DateTime primaryPerformance) {
        this.title = title;
        performanceDateTimes = Collections.singletonList(primaryPerformance);
    }


    public Performance(String title, List<DateTime> performanceDateTimes) {
        this.title = title;
        this.performanceDateTimes = performanceDateTimes;
    }

    public Performance(String title, List<DateTime> performanceDateTimes, List<DateTime> rehearsalDateTimes, int numberOfServices) {
        this.title = title;
        this.performanceDateTimes = performanceDateTimes;
        this.rehearsalDateTimes = rehearsalDateTimes;
        this.numberOfServices = numberOfServices;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumberOfServices(int numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

    public void setDateTimes(List<DateTime> performanceDateTimes) {
        this.performanceDateTimes = performanceDateTimes;
    }

    public void setPerformancePieces(Collection<PerformancePiece> performancePieces) {
        this.performancePieces = performancePieces;
    }

    public void setPerformanceDateTimes(List<DateTime> performanceDateTimes) {
        this.performanceDateTimes = performanceDateTimes;
    }

    public void setRehearsalDateTimes(List<DateTime> rehearsalDateTimes) {
        this.rehearsalDateTimes = rehearsalDateTimes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<DateTime> getPerformanceDateTimes() {
        return performanceDateTimes;
    }

    public List<DateTime> getRehearsalDateTimes() {
        return rehearsalDateTimes;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public Collection<PerformancePiece> getPerformancePieces() {
        return performancePieces;
    }

    public void setAllProps(Performance incoming) {
        if (incoming.getTitle() != null) {
            title = incoming.getTitle();
        }
        if (incoming.getPerformanceDateTimes() != null) {
            performanceDateTimes = incoming.getPerformanceDateTimes();
        }
        if (incoming.getRehearsalDateTimes() != null) {
            rehearsalDateTimes = incoming.getRehearsalDateTimes();
        }
        if (incoming.getNumberOfServices() > 0) {
            numberOfServices = incoming.getNumberOfServices();
        }
    }

    @Override
    public int compareTo(Performance next) {
        return performanceDateTimes.get(0).getDate().compareTo(next.performanceDateTimes.get(0).getDate());

    }
}

