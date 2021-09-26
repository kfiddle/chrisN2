package com.example.demo.junctionTables;


import com.example.demo.models.Performance;
import com.example.demo.models.Piece;

import javax.persistence.*;

@Entity
public class PerformancePiece {

    @Id
    @GeneratedValue
    private Long id;

    private int orderNumber;

    @ManyToOne
    private Performance performance;

    @ManyToOne
    private Piece piece;

    public PerformancePiece() {}

    public PerformancePiece(Performance performance, Piece piece) {
        this.performance = performance;
        this.piece = piece;
    }

    public PerformancePiece(int orderNumber, Performance performance, Piece piece) {
        this.orderNumber = orderNumber;
        this.performance = performance;
        this.piece = piece;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Long getId() {
        return id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Piece getPiece() {
        return piece;
    }
}
