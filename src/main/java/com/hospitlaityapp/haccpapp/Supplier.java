package com.hospitlaityapp.haccpapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier {

    @Id
    private String name;
    private String accountNumber;
    private String email;
    private String phoneNumber;

    public Supplier(String name, String accountNumber, String email, String phoneNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Supplier() {}

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
