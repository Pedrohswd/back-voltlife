package com.voltlife.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String postalCode;
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;
    private String country;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<HouseUser> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String cep) {
        this.postalCode = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<HouseUser> getUsers() {
        return users;
    }

    public void setUsers(List<HouseUser> users) {
        this.users = users;
    }
}
