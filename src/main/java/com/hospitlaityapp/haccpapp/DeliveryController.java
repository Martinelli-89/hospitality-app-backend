package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
@CrossOrigin
@RestController
public class DeliveryController {

    @Autowired
    DeliveriesService deliveriesService;

    //CREATE
    @PostMapping("/delivery")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        try {
            deliveriesService.addDelivery(delivery);
            return ResponseEntity.status(HttpStatus.CREATED).body(delivery);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(delivery);
        }
    }

    //READ
    @GetMapping("/delivery/id={id}")
    public ResponseEntity<Delivery> deliveryById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveriesService.getDeliveryById(id));
    }

    @GetMapping("/deliveries/supplier={supplier}")
    public ResponseEntity<ArrayList<Delivery>> getDeliveriesBySupplier(@PathVariable String supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveriesService.getDeliveriesBySupplier(supplier));
    }

    @GetMapping("/deliveries/type={type}")
    public ResponseEntity<ArrayList<Delivery>> deliveriesByType(@PathVariable String type) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveriesService.getDeliveriesByType(type));
    }

    @GetMapping("/deliveries/accepted={accepted}")
    public ResponseEntity<ArrayList<Delivery>> deliveriesByAcceptance(@PathVariable boolean accepted) {
        return ResponseEntity.status(HttpStatus.OK).body(deliveriesService.getDeliveriesByAcceptance(accepted));
    }

    @GetMapping("/deliveries/deliveredBefore={date}")
    public ResponseEntity<ArrayList<Delivery>> deliveriesByDeliveredBefore(@PathVariable String date) {
        LocalDate convertedDate = LocalDate.parse(date);
        return ResponseEntity.status(HttpStatus.OK).body(deliveriesService.getDeliveriesByDeliveredBefore(convertedDate));
    }

    @GetMapping("/deliveries/deliveredAfter={date}")
    public ResponseEntity<ArrayList<Delivery>> deliveriesByDeliveredAfter(@PathVariable String date) {
        LocalDate convertedDate = LocalDate.parse(date);
        return ResponseEntity.status(HttpStatus.OK).body(deliveriesService.getDeliveriesByDeliveredAfter(convertedDate));
    }


    //UPDATE

    @PostMapping("/delivery/{serial}")
    public ResponseEntity<Delivery> updateDelivery (@RequestBody Delivery newDelivery) {
        deliveriesService.updateDelivery(newDelivery);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newDelivery);
    }

    //DELETE
    @DeleteMapping("/delivery/{id}")
    @Transactional
    public ResponseEntity deleteEquipmentBySerial(@PathVariable Long id) {
        deliveriesService.deleteDeliveryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
