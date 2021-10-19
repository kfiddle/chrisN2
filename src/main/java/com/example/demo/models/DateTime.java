package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class DateTime implements Comparable<DateTime>{

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    private LocalTime startTime;
    private LocalTime endTime;

    public DateTime() {
    }

    public DateTime(LocalDate date) {
        this.date = date;
    }

    public DateTime(LocalDate date, LocalTime startTime) {
        this.date = date;
        this.startTime = startTime;
    }

    public DateTime(LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }


    @Override
    public int compareTo(DateTime next) {
        return date.compareTo(next.date);
    }
}
