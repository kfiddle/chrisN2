package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Performance {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private LocalDate date;
    private int numberOfServices;




    public Performance() {}
}

