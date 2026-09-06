package com.example.smartforest.model;

import jakarta.persistence.*;

@Entity
public class TreeSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commonName;
    private String scientificName;
    private String preferredSoilType;
    private Double waterRequirementMmPerYear;
    private Double growthRateMPerYear;
    private String climateZone;

    public TreeSpecies() {}

    public TreeSpecies(String commonName, String scientificName, String preferredSoilType,
                       Double waterRequirementMmPerYear, Double growthRateMPerYear, String climateZone) {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.preferredSoilType = preferredSoilType;
        this.waterRequirementMmPerYear = waterRequirementMmPerYear;
        this.growthRateMPerYear = growthRateMPerYear;
        this.climateZone = climateZone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCommonName() { return commonName; }
    public void setCommonName(String commonName) { this.commonName = commonName; }
    public String getScientificName() { return scientificName; }
    public void setScientificName(String scientificName) { this.scientificName = scientificName; }
    public String getPreferredSoilType() { return preferredSoilType; }
    public void setPreferredSoilType(String preferredSoilType) { this.preferredSoilType = preferredSoilType; }
    public Double getWaterRequirementMmPerYear() { return waterRequirementMmPerYear; }
    public void setWaterRequirementMmPerYear(Double waterRequirementMmPerYear) { this.waterRequirementMmPerYear = waterRequirementMmPerYear; }
    public Double getGrowthRateMPerYear() { return growthRateMPerYear; }
    public void setGrowthRateMPerYear(Double growthRateMPerYear) { this.growthRateMPerYear = growthRateMPerYear; }
    public String getClimateZone() { return climateZone; }
    public void setClimateZone(String climateZone) { this.climateZone = climateZone; }
}
