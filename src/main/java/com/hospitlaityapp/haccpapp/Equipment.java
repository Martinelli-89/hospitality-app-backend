package com.hospitlaityapp.haccpapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Equipment {


    @Id
    private String serialNumber;
    private String type;
    private LocalDate lastServiced;

    public Equipment(String serialNumber, String type, LocalDate lastServiced) {
        this.serialNumber = serialNumber;
        this.type = type;
        this.lastServiced = lastServiced;
    }

    public Equipment () {}

    public void setLastServiced(LocalDate lastServiced) {
        this.lastServiced = lastServiced;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getType() {
        return type;
    }

    public LocalDate getLastServiced() {
        return lastServiced;
    }
}
