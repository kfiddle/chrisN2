package com.example.demo.models;


import com.example.demo.junctionTables.PerformancePiece;

import javax.persistence.*;
import javax.security.auth.Subject;
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

    private String notes;

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

    public Performance(String title, List<DateTime> performanceDateTimes, List<DateTime> rehearsalDateTimes, int numberOfServices, String notes) {
        this.title = title;
        this.performanceDateTimes = performanceDateTimes;
        this.rehearsalDateTimes = rehearsalDateTimes;
        this.numberOfServices = numberOfServices;
        this.notes = notes;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setNumberOfServices(int numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getNotes() {
        return notes;
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
        if (incoming.getNotes() != null) {
            notes = incoming.getNotes();
        }


    }

    @Override
    public int compareTo(Performance next) {
        return performanceDateTimes.get(0).getDate().compareTo(next.performanceDateTimes.get(0).getDate());

    }
}

