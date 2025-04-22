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
    private String address;

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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public List<HouseUser> getUsers() {
        return users;
    }

    public void setUsers(List<HouseUser> users) {
        this.users = users;
    }
}
