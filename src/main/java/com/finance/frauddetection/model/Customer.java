package com.finance.frauddetection.model;

public class Customer {
    int id;
    String name;
    String accountNumber;
    String registeredCountry;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String name, String accountNumber, String registeredCountry){
        this.id=id;
        this.name=name;
        this.accountNumber=accountNumber;
        this.registeredCountry=registeredCountry;
    }


    public String getName() {
        return name;
    }

    public String getRegisteredCountry() {
        return registeredCountry;
    }

    public void setRegisteredCountry(String registeredCountry) {
        this.registeredCountry = registeredCountry;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

