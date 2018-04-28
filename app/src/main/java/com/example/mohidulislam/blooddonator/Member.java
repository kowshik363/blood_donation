package com.example.mohidulislam.blooddonator;

import java.io.Serializable;

public class Member implements Serializable {
    private int ID;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String dateOfBirth;
    private String gender;
    private String bloodGroup;
    private String city;

    public Member(String name, String phone, String email, String password, String dateOfBirth, String gender, String bloodGroup, String city) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.city = city;
    }

    public Member(int ID, String name, String phone, String email, String password, String dateOfBirth, String gender, String bloodGroup, String city) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getCity() {
        return city;
    }
}
