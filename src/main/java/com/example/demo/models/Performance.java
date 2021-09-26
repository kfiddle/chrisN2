package com.example.demo.models;


import com.example.demo.junctionTables.PerformancePiece;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Performance {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private LocalDate date;
    private int numberOfServices;

    @OneToMany
    private Collection<PerformancePiece> performancePieces;

    public Performance() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public Collection<PerformancePiece> getPerformancePieces() {
        return performancePieces;
    }
}

