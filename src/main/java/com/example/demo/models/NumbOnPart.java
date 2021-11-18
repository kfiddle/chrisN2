package com.example.demo.models;


import com.example.demo.enums.Part;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NumbOnPart {

    @Id
    @GeneratedValue
    private Long id;

    private Part part;
    private int number;

    @ManyToOne
    private Piece piece;

    public NumbOnPart() {
    }

    public NumbOnPart(Part part, int number) {
        this.part = part;
        this.number = number;
    }

    public NumbOnPart(Part part, int number, Piece piece) {
        this.part = part;
        this.number = number;
        this.piece = piece;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Long getId() {
        return id;
    }

    public Part getPart() {
        return part;
    }

    public int getNumber() {
        return number;
    }

    public Piece getPiece() {
        return piece;
    }
}
