package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnionLocal {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public UnionLocal() {}

    public UnionLocal(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
