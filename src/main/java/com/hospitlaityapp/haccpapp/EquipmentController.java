package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class EquipmentController {

    @Autowired
    EquipmentsService equipmentService;

    //CREATE
    @PostMapping("/equipment")
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {
        try {
            equipmentService.addEquipment(equipment);
            return ResponseEntity.status(HttpStatus.CREATED).body(equipment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(equipment);
        }
    }

    //READ
    @GetMapping("/equipment/serial={serialNumber}")
    public ResponseEntity<Equipment> equipment(@PathVariable String serialNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.getEquipmentBySerialNumber(serialNumber));
    }

    @GetMapping("/equipment/type={type}")
    public ResponseEntity<ArrayList<Equipment>> equipmentByType(@PathVariable String type) {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.getEquipmentByType(type));
    }

    @GetMapping("/equipment/servicedBefore={date}")
    public ResponseEntity<ArrayList<Equipment>> equipmentByServicedDate(@PathVariable String date) {
        LocalDate convertedDate = LocalDate.parse(date);
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.getEquipmentByServicedBefore(convertedDate));
    }

    @GetMapping("/equipment/servicedAfter={date}")
    public ResponseEntity<ArrayList<Equipment>> equipmentByServicedAfterDate(@PathVariable String date) {
        LocalDate convertedDate = LocalDate.parse(date);
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.getEquipmentByServicedAfter(convertedDate));
    }

    @GetMapping("/equipments")
    public ResponseEntity<ArrayList<Map[]>> allEquipment() {
        return ResponseEntity.status(HttpStatus.OK).body(equipmentService.getAllEquipment());
    }

    //UPDATE

    @PostMapping("/equipment/{serial}")
    public ResponseEntity<Equipment> updateEquipment (@RequestBody Equipment newEquipment) {
        equipmentService.updateEquipment(newEquipment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newEquipment);
    }

    //DELETE
    @DeleteMapping("/equipment/{serialNumber}")
    @Transactional
    public ResponseEntity deleteEquipmentBySerial(@PathVariable String serialNumber) {
        equipmentService.deleteEquipmentBySerialNumber(serialNumber);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
