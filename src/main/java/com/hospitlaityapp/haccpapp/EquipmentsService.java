package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Service
public class EquipmentsService {

    @Autowired
    EquipmentsRepository equipmentsRepository;

    //CREATE
    public void addEquipment(Equipment newEquipment) {
        Optional<Equipment> equipment = Optional.ofNullable(equipmentsRepository.getEquipmentBySerialNumber(newEquipment.getSerialNumber()));
        if(equipment.isPresent()) {
            throw new EquipmentAlreadyExistException();
        } else {
            equipmentsRepository.save(newEquipment);
        }
    }

    //READ
    public Equipment getEquipmentBySerialNumber(String serialNumber) {
        return equipmentsRepository.getEquipmentBySerialNumber(serialNumber);
    }

    public ArrayList<Equipment> getEquipmentByType(String type) {
        return equipmentsRepository.getEquipmentByType(type);
    }

    public ArrayList<Equipment> getEquipmentByServicedBefore(LocalDate date) {
        return equipmentsRepository.getEquipmentByServicedBefore(date);
    }

    public ArrayList<Equipment> getEquipmentByServicedAfter(LocalDate date) {
        return equipmentsRepository.getEquipmentByServicedAfter(date);
    }

    public ArrayList<Map[]> getAllEquipment() {
        return equipmentsRepository.getAllEquipment();
    }

    //UPDATE

    public void updateEquipment (Equipment newEquipment) {
        equipmentsRepository.save(newEquipment);
    }

    //DELETE
    public void deleteEquipmentBySerialNumber(String serialNumber) {
        equipmentsRepository.deleteEquipmentBySerialNumber(serialNumber);
    }

}
