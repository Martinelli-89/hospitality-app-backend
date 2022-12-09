package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class DeliveriesService {

    @Autowired
    DeliveriesRepository deliveriesRepository;

    //CREATE
    public void addDelivery(Delivery newDelivery) {
        deliveriesRepository.save(newDelivery);
    }

    //READ
    public ArrayList<Delivery> getDeliveriesBySupplier(String supplier) {
        return deliveriesRepository.getDeliveriesBySupplier(supplier);
    }

    public Delivery getDeliveryById(Long id) {
        return deliveriesRepository.getDeliveryById(id);
    }

    public ArrayList<Delivery> getDeliveriesByType(String type) {
        return deliveriesRepository.getDeliveriesByType(type);
    }

    public ArrayList<Delivery> getDeliveriesByDeliveredBefore(LocalDate date) {
        return deliveriesRepository.getDeliveriesByDeliveredBefore(date);
    }

    public ArrayList<Delivery> getDeliveriesByDeliveredAfter(LocalDate date) {
        return deliveriesRepository.getDeliveriesByDeliveredAfter(date);
    }

    public ArrayList<Delivery> getDeliveriesByAcceptance(boolean accepted) {
        return deliveriesRepository.getDeliveriesByAcceptance(accepted);
    }

    //UPDATE

    public void updateDelivery (Delivery newDelivery) {
        deliveriesRepository.save(newDelivery);
    }

    //DELETE
    public void deleteDeliveryById(Long id) {
        deliveriesRepository.deleteDeliveryById(id);
    }

}
