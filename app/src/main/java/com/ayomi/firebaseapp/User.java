package com.ayomi.firebaseapp;

public class User {

    private String Name;
    private String Phone;
    private String Occupation;
    private String Address;

    public User() {
    }

    public User(String name, String phone, String occupation, String address) {
        Name = name;
        Phone = phone;
        Occupation = occupation;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
