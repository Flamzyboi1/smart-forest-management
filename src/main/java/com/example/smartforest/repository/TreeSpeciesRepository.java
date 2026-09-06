package com.example.smartforest.repository;

import com.example.smartforest.model.TreeSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TreeSpeciesRepository extends JpaRepository<TreeSpecies, Long> {
    List<TreeSpecies> findByPreferredSoilType(String soilType);
    List<TreeSpecies> findByClimateZone(String climateZone);
}
