package com.example.smartforest.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SoilWaterBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Double precipitationMm;
    private Double evapotranspirationMm;
    private Double irrigationMm;
    private Double soilMoisturePercent;

    public SoilWaterBalance() {}

    public SoilWaterBalance(LocalDate date, Double precipitationMm, Double evapotranspirationMm,
                            Double irrigationMm, Double soilMoisturePercent) {
        this.date = date;
        this.precipitationMm = precipitationMm;
        this.evapotranspirationMm = evapotranspirationMm;
        this.irrigationMm = irrigationMm;
        this.soilMoisturePercent = soilMoisturePercent;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Double getPrecipitationMm() { return precipitationMm; }
    public void setPrecipitationMm(Double precipitationMm) { this.precipitationMm = precipitationMm; }
    public Double getEvapotranspirationMm() { return evapotranspirationMm; }
    public void setEvapotranspirationMm(Double evapotranspirationMm) { this.evapotranspirationMm = evapotranspirationMm; }
    public Double getIrrigationMm() { return irrigationMm; }
    public void setIrrigationMm(Double irrigationMm) { this.irrigationMm = irrigationMm; }
    public Double getSoilMoisturePercent() { return soilMoisturePercent; }
    public void setSoilMoisturePercent(Double soilMoisturePercent) { this.soilMoisturePercent = soilMoisturePercent; }
}
