package com.example.e_wasteapp;

public class EWasteData {

    private String name,phone,email,address,Condition,Quantity,brand,model,key;

    public EWasteData() {
    }

    public EWasteData(String name, String phone, String email,String address, String condition, String quantity, String brand, String model, String key) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.Condition = condition;
        this.Quantity = quantity;
        this.brand = brand;
        this.model = model;
        this.key = key;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
