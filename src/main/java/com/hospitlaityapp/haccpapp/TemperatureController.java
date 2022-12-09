package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
@CrossOrigin
@RestController
public class TemperatureController {

    @Autowired
    TemperaturesService temperaturesService;

    //CREATE
    @PostMapping("/temperature")
    public ResponseEntity<Temperature> createTemperature(@RequestBody Temperature temperature) {
        try {
            temperaturesService.addTemperature(temperature);
            return ResponseEntity.status(HttpStatus.CREATED).body(temperature);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(temperature);
        }
    }

    //READ
    @GetMapping("/temperature/id={id}")
    public ResponseEntity<Temperature> temperatureById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(temperaturesService.getTemperatureById(id));
    }

    @GetMapping("/temperature/serial={serial}")
    public ResponseEntity<ArrayList<Temperature>> getTemperaturesByEquipmentSerial(@PathVariable String serial) {
        return ResponseEntity.status(HttpStatus.OK).body(temperaturesService.getTemperaturesByEquipmentSerial(serial));
    }

    @GetMapping("/temperature/type={type}")
    public ResponseEntity<ArrayList<Temperature>> temperaturesByType(@PathVariable String type) {
        return ResponseEntity.status(HttpStatus.OK).body(temperaturesService.getTemperaturesByType(type));
    }

    @GetMapping("/temperature/above={temperature}")
    public ResponseEntity<ArrayList<Temperature>> temperatureBelow(@PathVariable float temperature) {
        return ResponseEntity.status(HttpStatus.OK).body(temperaturesService.getTemperaturesAbove(temperature));
    }

    @GetMapping("/temperature/below={temperature}")
    public ResponseEntity<ArrayList<Temperature>> temperatureAbove(@PathVariable float temperature) {
        return ResponseEntity.status(HttpStatus.OK).body(temperaturesService.getTemperaturesBelow(temperature));
    }

    @GetMapping("/temperature/enteredBefore={date}")
    public ResponseEntity<ArrayList<Temperature>> temperaturesEnteredBefore(@PathVariable String date) {
        LocalDate convertedDate = LocalDate.parse(date);
        return ResponseEntity.status(HttpStatus.OK).body(temperaturesService.getTemperaturesEnteredBefore(convertedDate));
    }

    @GetMapping("/deliveries/enteredAfter={date}")
    public ResponseEntity<ArrayList<Temperature>> temperaturesEnteredAfter(@PathVariable String date) {
        LocalDate convertedDate = LocalDate.parse(date);
        return ResponseEntity.status(HttpStatus.OK).body(temperaturesService.getTemperaturesEnteredAfter(convertedDate));
    }

    //UPDATE

    @PostMapping("/temperature/{id}")
    public ResponseEntity<Temperature> updateTemperature (@RequestBody Temperature newTemperature) {
        temperaturesService.updateTemperature(newTemperature);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newTemperature);
    }
}
