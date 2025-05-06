package com.voltlife.backend.model.dtos;

import java.util.List;

public class HouseDTO {
    private Long id;
    private String name;
    private String cep;
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;
    private String country;
    private List<HouseUserDTO> users;

    public HouseDTO(Long id, String name, String cep, String street, String number,
                    String district, String city, String state, String country,
                    List<HouseUserDTO> users) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public List<HouseUserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<HouseUserDTO> users) {
        this.users = users;
    }
}