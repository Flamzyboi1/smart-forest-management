package com.example.smartforest.controller;

import com.example.smartforest.model.TreeSpecies;
import com.example.smartforest.repository.TreeSpeciesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeRecommendationController {

    private final TreeSpeciesRepository speciesRepo;

    public TreeRecommendationController(TreeSpeciesRepository speciesRepo) {
        this.speciesRepo = speciesRepo;
    }

    @GetMapping
    public List<TreeSpecies> allSpecies() {
        return speciesRepo.findAll();
    }

    @GetMapping("/by-soil")
    public List<TreeSpecies> recommendBySoilType(@RequestParam String soilType) {
        return speciesRepo.findByPreferredSoilType(soilType);
    }

    @GetMapping("/by-climate")
    public List<TreeSpecies> recommendByClimate(@RequestParam String climateZone) {
        return speciesRepo.findByClimateZone(climateZone);
    }
}
