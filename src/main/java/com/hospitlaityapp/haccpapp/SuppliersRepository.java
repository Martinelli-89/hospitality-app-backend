package com.hospitlaityapp.haccpapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, String> {

    //READ
    @Query(value="SELECT * FROM supplier WHERE name = ?1", nativeQuery=true)
    Supplier getSupplierByName(String name);

    @Query(value="SELECT DISTINCT name FROM supplier", nativeQuery=true)
    List<String> getAllSuppliers();

    //DELETE
    void deleteSupplierByName(String name);


}
