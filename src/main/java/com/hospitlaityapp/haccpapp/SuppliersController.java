package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class SuppliersController {

    @Autowired
    SuppliersService supplierService;

    //CREATE
    @PostMapping("/supplier")
    public ResponseEntity<Supplier> createGreeting(@RequestBody Supplier supplier) {
        try {
            supplierService.addSupplier(supplier);
            return ResponseEntity.status(HttpStatus.CREATED).body(supplier);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(supplier);
        }
    }

    //READ
    @GetMapping("/supplier/{name}")
    public ResponseEntity<Supplier> supplier(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getSupplierByName(name));
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<String>> allSuppliers() {
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.getAllSuppliers());
    }

    //UPDATE

    @PostMapping("/supplier/{id}")
    public ResponseEntity<Supplier> updateSupplier (@RequestBody Supplier newSupplier) {
        supplierService.updateSupplier(newSupplier);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newSupplier);
    }

    //DELETE
    @DeleteMapping("/supplier/{id}")
    @Transactional
    public ResponseEntity deleteSupplierByName(@PathVariable String id) {
        supplierService.deleteSupplierByName(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
