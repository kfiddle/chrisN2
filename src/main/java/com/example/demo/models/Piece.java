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
}
