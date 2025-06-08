package com.voltlife.backend.model;

import com.voltlife.backend.model.enuns.Category;
import jakarta.persistence.*;

@Entity
public class Device {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String mark;
    @Column(unique=true)
    private String code;
    private String model;
    private double voltage; // em Volts
    private double monthlyConsumption; // em kWh/mês
    private double annualConsumption;  // em kWh/ano

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private House house;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getMonthlyConsumption() {
        return monthlyConsumption;
    }

    public void setMonthlyConsumption(double monthlyConsumption) {
        this.monthlyConsumption = monthlyConsumption;
    }

    public double getAnnualConsumption() {
        return annualConsumption;
    }

    public void setAnnualConsumption(double annualConsumption) {
        this.annualConsumption = annualConsumption;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
