package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class TemperaturesService {

    @Autowired
    TemperaturesRepository temperaturesRepository;

    //CREATE
    public void addTemperature(Temperature newTemperature) {
        temperaturesRepository.save(newTemperature);
    }

    //READ
    public Temperature getTemperatureById(long id) {
        return temperaturesRepository.getTemperatureById(id);
    }

    public ArrayList<Temperature> getTemperaturesByType(String type) {
        return temperaturesRepository.getTemperaturesByType(type);
    }

    public ArrayList<Temperature> getTemperaturesByEquipmentSerial(String serial) {
        return temperaturesRepository.getTemperaturesByEquipmentSerial(serial);
    }

    public ArrayList<Temperature> getTemperaturesEnteredBefore(LocalDate date) {
        return temperaturesRepository.getTemperaturesEnteredBefore(date);
    }

    public ArrayList<Temperature> getTemperaturesEnteredAfter(LocalDate date) {
        return temperaturesRepository.getTemperaturesEnteredAfter(date);
    }

    public ArrayList<Temperature> getTemperaturesBelow(float temperature) {
        return temperaturesRepository.getTemperaturesBelow(temperature);
    }

    public ArrayList<Temperature> getTemperaturesAbove(float temperature) {
        return temperaturesRepository.getTemperaturesAbove(temperature);
    }

    //UPDATE

    public void updateTemperature (Temperature newTemperature) {
        temperaturesRepository.save(newTemperature);
    }

}
