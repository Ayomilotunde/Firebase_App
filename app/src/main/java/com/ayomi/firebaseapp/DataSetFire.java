package com.ayomi.firebaseapp;

public class DataSetFire {


    String Name;
     String Phone;
     String Occupation;
    String Address;

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

    public DataSetFire() {
    }

    public DataSetFire(String name, String phone, String occupation, String address) {
        Name = name;
        Phone = phone;
        Occupation = occupation;
        Address = address;
    }
}
