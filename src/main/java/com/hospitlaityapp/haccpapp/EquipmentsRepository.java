package com.hospitlaityapp.haccpapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface EquipmentsRepository extends JpaRepository<Equipment, String> {

    //READ
    @Query(value="SELECT * FROM equipment WHERE serial_number = ?1", nativeQuery=true)
    Equipment getEquipmentBySerialNumber(String serial_number);

    @Query(value="SELECT DISTINCT serial_number, type  FROM equipment", nativeQuery=true)
    ArrayList<Map[]> getAllEquipment();

    @Query(value="SELECT * FROM equipment WHERE type = ?1", nativeQuery=true)
    ArrayList<Equipment> getEquipmentByType(String type);

    @Query(value="SELECT * FROM equipment WHERE last_serviced < ?1", nativeQuery=true)
    ArrayList<Equipment> getEquipmentByServicedBefore(LocalDate date);

    @Query(value="SELECT * FROM equipment WHERE last_serviced > ?1", nativeQuery=true)
    ArrayList<Equipment> getEquipmentByServicedAfter(LocalDate date);

    //DELETE
    void deleteEquipmentBySerialNumber(String serialNumber);

}
