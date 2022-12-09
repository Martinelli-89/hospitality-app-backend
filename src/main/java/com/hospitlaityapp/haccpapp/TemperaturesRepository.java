package com.hospitlaityapp.haccpapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public interface TemperaturesRepository extends JpaRepository<Temperature, Long> {

    //READ
    @Query(value="SELECT * FROM temperature WHERE id = ?1", nativeQuery=true)
    Temperature getTemperatureById(Long id);

    @Query(value="SELECT *  FROM temperature WHERE equipment_type = ?1", nativeQuery=true)
    ArrayList<Temperature> getTemperaturesByType(String type);

    @Query(value="SELECT * FROM temperature WHERE equipment_serial_number = ?1", nativeQuery=true)
    ArrayList<Temperature> getTemperaturesByEquipmentSerial(String serial);

    @Query(value="SELECT * FROM temperature WHERE date < ?1", nativeQuery=true)
    ArrayList<Temperature> getTemperaturesEnteredBefore(LocalDate date);

    @Query(value="SELECT * FROM temperature WHERE date > ?1", nativeQuery=true)
    ArrayList<Temperature> getTemperaturesEnteredAfter(LocalDate date);

    @Query(value="SELECT * FROM temperature WHERE temperature < ?1", nativeQuery=true)
    ArrayList<Temperature> getTemperaturesBelow(Float temperature);

    @Query(value="SELECT * FROM temperature WHERE temperature > ?1", nativeQuery=true)
    ArrayList<Temperature> getTemperaturesAbove(Float temperature);
}
