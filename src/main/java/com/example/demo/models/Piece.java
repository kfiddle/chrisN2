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
    private String composerName;
    private String arranger;
    private String otherName;
    private String publisher;
    private String libNumber;

    private int duration;
    private String notes;

    @OneToMany(mappedBy = "piece")
    private Collection<NumbOnPart> orchestration;

    @OneToMany
    private Collection<PerformancePiece> performancePieces;

    public Piece() {
    }

    public Piece(String title) {
        this.title = title;
    }

    public Piece(String title, String composerName) {
        this.title = title;
        this.composerName = composerName;
    }


    public Piece(String title, String composerFirstName, String composerName, int duration, String notes) {
        this.title = title;
        this.composerName = composerName;
        this.duration = duration;
        this.notes = notes;
    }

    public Piece(String title, String composerFirstName, String composerName, String arranger, String otherName, String publisher, String libNumber, int duration, String notes) {
        this.title = title;
        this.composerName = composerName;
        this.arranger = arranger;
        this.otherName = otherName;
        this.publisher = publisher;
        this.libNumber = libNumber;
        this.duration = duration;
        this.notes = notes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposerName(String composerName) {
        this.composerName = composerName;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public void setPerformancePieces(Collection<PerformancePiece> performancePieces) {
        this.performancePieces = performancePieces;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getComposerName() {
        return composerName;
    }

    public Collection<PerformancePiece> getPerformancePieces() {
        return performancePieces;
    }

    public int getDuration() {
        return duration;
    }

    public String getNotes() {
        return notes;
    }

    public String getArranger() {
        return arranger;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getLibNumber() {
        return libNumber;
    }

    public void setAllProps(Piece incoming) {
        if (incoming.getTitle() != null) {
            title = incoming.getTitle();
        }
        if (incoming.getComposerName() != null) {
            composerName = incoming.getComposerName();
        }
        if (incoming.getArranger() != null) {
            arranger = incoming.getArranger();
        }
        if (incoming.getLibNumber() != null) {
            libNumber = incoming.getLibNumber();
        }
        if (incoming.getPublisher() != null) {
            publisher = incoming.getPublisher();
        }
        if (incoming.getDuration() > 0) {
            duration = incoming.getDuration();
        }
        if (incoming.getNotes() != null) {
            notes = incoming.getNotes();
        }


    }

}
