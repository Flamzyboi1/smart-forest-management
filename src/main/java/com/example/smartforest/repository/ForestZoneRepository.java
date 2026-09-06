package com.example.smartforest.repository;

import com.example.smartforest.model.ForestZone;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ForestZoneRepository extends JpaRepository<ForestZone, Long> {
    List<ForestZone> findBySoilType(String soilType);
    List<ForestZone> findByClimateZone(String climateZone);
}
