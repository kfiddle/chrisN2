package com.example.demo.models;

import com.example.demo.enums.Part;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Contract {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Part part;

    private Part part2;

    private int rank;

    @OneToOne
    private Player player;

    public Contract() {
    }

    public Contract(Part part, int rank) {
        this.part = part;
        this.rank = rank;
    }

    public Contract(Part part, int rank, Part part2) {
        this.part = part;
        this.rank = rank;
        this.part2 = part2;
    }

    public Contract(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setPart2(Part part2) {
        this.part2 = part2;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Player getPlayer() {
        return player;
    }

    public Part getPart() {
        return part;
    }

    public int getRank() {
        return rank;
    }

    public Part getPart2() {
        return part2;
    }

    public String toString() {

        if (part2 != null) {
            return part.toString() + " " + rank + " " + part2.toString();
        } else if (part == Part.VIOLIN1 && rank == 1) {
            return "Concertmaster";
        } else if (rank == 1) {
            return part.toString() + " Principal";
        } else {
            return part.toString() + " " + rank;
        }
    }

    public void setAllProps(Contract otherContract) {
        if (otherContract.getPart() != null) {
            part = otherContract.getPart();
        }
        if (otherContract.getRank() > 0) {
            rank = otherContract.getRank();
        }
        if (otherContract.getPart2() != null) {
            part2 = otherContract.getPart2();
        }


    }
}
