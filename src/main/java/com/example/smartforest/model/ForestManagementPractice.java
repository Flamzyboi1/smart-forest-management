package com.example.smartforest.model;

import jakarta.persistence.*;

@Entity
public class ForestManagementPractice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double waterSavingPercent;
    private Double costPerHectare;

    public ForestManagementPractice() {}

    public ForestManagementPractice(String name, String description, Double waterSavingPercent, Double costPerHectare) {
        this.name = name;
        this.description = description;
        this.waterSavingPercent = waterSavingPercent;
        this.costPerHectare = costPerHectare;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getWaterSavingPercent() { return waterSavingPercent; }
    public void setWaterSavingPercent(Double waterSavingPercent) { this.waterSavingPercent = waterSavingPercent; }
    public Double getCostPerHectare() { return costPerHectare; }
    public void setCostPerHectare(Double costPerHectare) { this.costPerHectare = costPerHectare; }
}
