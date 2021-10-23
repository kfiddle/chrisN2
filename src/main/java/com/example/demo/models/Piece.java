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
    private String composerFirstName;
    private String composerLastName;

    private int duration;
    private String notes;

    @OneToMany
    private Collection<PerformancePiece> performancePieces;

    public Piece() {
    }

    public Piece(String title) {
        this.title = title;
    }

    public Piece(String title, String composerLastName) {
        this.title = title;
        this.composerLastName = composerLastName;
    }

    public Piece(String title, String composerFirstName, String composerLastName) {
        this.title = title;
        this.composerFirstName = composerFirstName;
        this.composerLastName = composerLastName;
    }

    public Piece(String title, String composerFirstName, String composerLastName, int duration, String notes) {
        this.title = title;
        this.composerFirstName = composerFirstName;
        this.composerLastName = composerLastName;
        this.duration = duration;
        this.notes = notes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComposerFirstName(String composerFirstName) {
        this.composerFirstName = composerFirstName;
    }

    public void setComposerLastName(String composerLastName) {
        this.composerLastName = composerLastName;
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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getComposerFirstName() {
        return composerFirstName;
    }

    public String getComposerLastName() {
        return composerLastName;
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

    public void setAllProps(Piece incoming) {
        if (incoming.getTitle() != null) {
            title = incoming.getTitle();
        }
        if (incoming.getComposerFirstName() != null) {
            composerFirstName = incoming.getComposerFirstName();
        }
        if (incoming.getComposerLastName() != null) {
            composerLastName = incoming.getComposerLastName();
        }
        if (incoming.getDuration() > 0) {
            duration = incoming.getDuration();
        }
        if (incoming.getNotes() != null) {
            notes = incoming.getNotes();
        }


    }

}
