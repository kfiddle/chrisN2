package com.example.demo.junctionTables;


import com.example.demo.models.Performance;
import com.example.demo.models.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlayerPerformanceReply {

    @Id
    @GeneratedValue
    private Long id;

    private boolean available;

    @ManyToOne
    private Performance performance;

    @ManyToOne
    private Player player;

    public PlayerPerformanceReply() {}

    public PlayerPerformanceReply(Player player, Performance performance, boolean available) {
        this.performance = performance;
        this.player = player;
        this.available = available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Player getPlayer() {
        return player;
    }

}
