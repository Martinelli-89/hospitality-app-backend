package com.hospitlaityapp.haccpapp;

public class EquipmentAlreadyExistException extends RuntimeException{

    public EquipmentAlreadyExistException() {
        super("An item with that serial number already exist");
    }

}
