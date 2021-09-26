package com.example.demo.models;


import com.example.demo.junctionTables.PerformancePiece;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Piece {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String composer;

    @OneToMany
    private Collection<PerformancePiece> performancePieces;

    public Piece() {}

    public Piece(String title) {
        this.title = title;
    }

    public Piece(String title, String composer) {
        this.title = title;
        this.composer = composer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposer(String composer) {
        this.composer = composer;
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

    public String getComposer() {
        return composer;
    }

    public Collection<PerformancePiece> getPerformancePieces() {
        return performancePieces;
    }
}
