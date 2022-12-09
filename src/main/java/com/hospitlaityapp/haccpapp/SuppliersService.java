package com.hospitlaityapp.haccpapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {

    @Autowired
    SuppliersRepository suppliersRepository;

    //CREATE
    public void addSupplier(Supplier newSupplier) {
        Optional<Supplier> supplier = Optional.ofNullable(suppliersRepository.getSupplierByName(newSupplier.getName()));
        if(!supplier.isEmpty()) {
            throw new SupplierAlreadyExistException();
        } else {
            suppliersRepository.save(newSupplier);
        }
    }

    //READ
    public Supplier getSupplierByName(String name) {
        return suppliersRepository.getSupplierByName(name);
    }

    public List<String> getAllSuppliers() {
        return suppliersRepository.getAllSuppliers();
    }

    //UPDATE

    public void updateSupplier (Supplier newSupplier) {
        suppliersRepository.save(newSupplier);
    }

    //DELETE
    public void deleteSupplierByName(String id) {
        suppliersRepository.deleteSupplierByName(id);
    }

}
