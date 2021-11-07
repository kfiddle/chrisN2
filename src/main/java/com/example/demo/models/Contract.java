package com.example.demo.models;

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

    @OneToOne
    private Player player;

    public Contract() {
    }

    public Contract(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
