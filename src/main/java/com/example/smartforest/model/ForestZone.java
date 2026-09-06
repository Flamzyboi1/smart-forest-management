package com.example.smartforest.model;

import jakarta.persistence.*;

@Entity
public class ForestZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double areaHectares;
    private String soilType;
    private String climateZone;

    public ForestZone() {}

    public ForestZone(String name, Double areaHectares, String soilType, String climateZone) {
        this.name = name;
        this.areaHectares = areaHectares;
        this.soilType = soilType;
        this.climateZone = climateZone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getAreaHectares() { return areaHectares; }
    public void setAreaHectares(Double areaHectares) { this.areaHectares = areaHectares; }
    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }
    public String getClimateZone() { return climateZone; }
    public void setClimateZone(String climateZone) { this.climateZone = climateZone; }
}
