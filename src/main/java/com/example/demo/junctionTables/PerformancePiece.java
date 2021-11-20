package com.example.demo.junctionTables;


import com.example.demo.models.NumbOnPart;
import com.example.demo.models.Performance;
import com.example.demo.models.Piece;
import com.example.demo.models.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

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

    @ElementCollection
    private Collection<PInChair> chairsToFill;

//    @OneToMany(mappedBy = "performancePiece")
//    Set<PerformancePiece_Player> ppps;

    public PerformancePiece() {
    }

    public PerformancePiece(Performance performance, Piece piece) {
        this.performance = performance;
        this.piece = piece;
    }

    public PerformancePiece(Performance performance, Piece piece, int orderNumber) {
        this.performance = performance;
        this.piece = piece;
        this.orderNumber = orderNumber;
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

    public void setChairsToFill(Collection<PInChair> chairsToFill) {
        this.chairsToFill = chairsToFill;
    }

    public void addChairToFill(PInChair pInChair) {
        chairsToFill.add(pInChair);
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

    public Collection<PInChair> getChairsToFill() {
        return chairsToFill;
    }

    public void makeSomeEmptyChairs() {
        Collection<PInChair> chairsToFill = new ArrayList<>();
        for (NumbOnPart numbOnPart : piece.getOrchestration()) {
            for (int j = 1; j <= numbOnPart.getNumber(); j++) {
                PInChair chairToFill = new PInChair(numbOnPart.getPart(), j);
                chairsToFill.add(chairToFill);
            }
        }
        this.setChairsToFill(chairsToFill);
    }

}
