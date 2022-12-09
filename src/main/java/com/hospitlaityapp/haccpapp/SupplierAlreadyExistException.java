package com.hospitlaityapp.haccpapp;

public class SupplierAlreadyExistException extends RuntimeException{

    public SupplierAlreadyExistException() {
        super("That supplier already exist");
    }

}
