package com.hospitlaityapp.haccpapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String equipmentSerialNumber;
    private String equipmentType;
    private float temperature;
    private LocalDate date = LocalDate.now();
    private LocalDateTime dateCreated;

    public Temperature(long id, String equipmentSerialNumber, String equipmentType, float temperature, LocalDate date) {
        this.id = id;
        this.equipmentSerialNumber = equipmentSerialNumber;
        this.equipmentType = equipmentType;
        this.temperature = temperature;
        this.date = date;
        this.dateCreated = LocalDateTime.now();
    }

    public Temperature () {}

    public long getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getEquipmentSerialNumber() {
        return equipmentSerialNumber;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public float getTemperature() {
        return temperature;
    }

    public LocalDate getDate() {
        return date;
    }
}
