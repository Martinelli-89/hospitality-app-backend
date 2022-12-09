package com.hospitlaityapp.haccpapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface DeliveriesRepository extends JpaRepository<Delivery, Long> {

    //READ
    @Query(value="SELECT * FROM delivery WHERE id = ?1", nativeQuery=true)
    Delivery getDeliveryById(Long id);

    @Query(value="SELECT *  FROM delivery WHERE type = ?1", nativeQuery=true)
    ArrayList<Delivery> getDeliveriesByType(String type);

    @Query(value="SELECT * FROM delivery WHERE supplier = ?1", nativeQuery=true)
    ArrayList<Delivery> getDeliveriesBySupplier(String supplier);

    @Query(value="SELECT * FROM delivery WHERE accepted = ?1", nativeQuery=true)
    ArrayList<Delivery> getDeliveriesByAcceptance(boolean accepted);

    @Query(value="SELECT * FROM delivery WHERE date < ?1", nativeQuery=true)
    ArrayList<Delivery> getDeliveriesByDeliveredBefore(LocalDate date);

    @Query(value="SELECT * FROM delivery WHERE date > ?1", nativeQuery=true)
    ArrayList<Delivery> getDeliveriesByDeliveredAfter(LocalDate date);

    //DELETE
    void deleteDeliveryById(Long id);

}
