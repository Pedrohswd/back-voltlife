package com.voltlife.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.voltlife.backend.model.enuns.HouseRole;
import jakarta.persistence.*;

@Entity
public class HouseUser {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    private House house;


    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private HouseRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HouseRole getRole() {
        return role;
    }

    public void setRole(HouseRole role) {
        this.role = role;
    }
}
