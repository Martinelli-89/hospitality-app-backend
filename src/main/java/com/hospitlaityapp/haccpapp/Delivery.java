package com.hospitlaityapp.haccpapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Delivery {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String supplier;
    private String type;
    private float temperature;
    private LocalDate date = LocalDate.now();
    private LocalDateTime dateCreated;
    private boolean accepted;

    public Delivery(long id, String supplier, String type, float temperature, LocalDate date, boolean accepted) {
        this.id = id;
        this.supplier = supplier;
        this.type = type;
        this.temperature = temperature;
        this.date = date;
        this.accepted = accepted;
        this.dateCreated = LocalDateTime.now();
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public Delivery () {}

    public long getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getType() {
        return type;
    }

    public float getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
