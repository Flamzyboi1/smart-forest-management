package com.example.smartforest.model;

import jakarta.persistence.*;

@Entity
public class DominantTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TreeSpecies species;

    private Double heightM;
    private Double dbhCm;
    private Integer ageYears;
    private String healthStatus;

    public DominantTree() {}

    public DominantTree(TreeSpecies species, Double heightM, Double dbhCm, Integer ageYears, String healthStatus) {
        this.species = species;
        this.heightM = heightM;
        this.dbhCm = dbhCm;
        this.ageYears = ageYears;
        this.healthStatus = healthStatus;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TreeSpecies getSpecies() { return species; }
    public void setSpecies(TreeSpecies species) { this.species = species; }
    public Double getHeightM() { return heightM; }
    public void setHeightM(Double heightM) { this.heightM = heightM; }
    public Double getDbhCm() { return dbhCm; }
    public void setDbhCm(Double dbhCm) { this.dbhCm = dbhCm; }
    public Integer getAgeYears() { return ageYears; }
    public void setAgeYears(Integer ageYears) { this.ageYears = ageYears; }
    public String getHealthStatus() { return healthStatus; }
    public void setHealthStatus(String healthStatus) { this.healthStatus = healthStatus; }
}
