package com.example.smartforest.service;

import com.example.smartforest.model.*;
import com.example.smartforest.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TreeSpeciesRepository speciesRepo;
    private final ForestZoneRepository zoneRepo;
    private final DominantTreeRepository treeRepo;
    private final ForestManagementPracticeRepository practiceRepo;
    private final SoilWaterBalanceRepository balanceRepo;

    public DataInitializer(TreeSpeciesRepository speciesRepo,
                           ForestZoneRepository zoneRepo,
                           DominantTreeRepository treeRepo,
                           ForestManagementPracticeRepository practiceRepo,
                           SoilWaterBalanceRepository balanceRepo) {
        this.speciesRepo = speciesRepo;
        this.zoneRepo = zoneRepo;
        this.treeRepo = treeRepo;
        this.practiceRepo = practiceRepo;
        this.balanceRepo = balanceRepo;
    }

    @Override
    public void run(String... args) {
        TreeSpecies oak = speciesRepo.save(new TreeSpecies("Oak", "Quercus robur", "Loamy", 600.0, 0.5, "Temperate"));
        TreeSpecies pine = speciesRepo.save(new TreeSpecies("Scots Pine", "Pinus sylvestris", "Sandy", 450.0, 0.6, "Temperate"));
        TreeSpecies birch = speciesRepo.save(new TreeSpecies("Silver Birch", "Betula pendula", "Sandy", 500.0, 0.7, "Temperate"));
        TreeSpecies spruce = speciesRepo.save(new TreeSpecies("Norway Spruce", "Picea abies", "Loamy", 700.0, 0.8, "Temperate"));

        zoneRepo.save(new ForestZone("North Zone", 120.5, "Loamy", "Temperate"));
        zoneRepo.save(new ForestZone("South Zone", 95.0, "Sandy", "Temperate"));
        zoneRepo.save(new ForestZone("East Zone", 80.3, "Sandy", "Temperate"));

        treeRepo.save(new DominantTree(oak, 22.0, 45.0, 60, "Good"));
        treeRepo.save(new DominantTree(pine, 25.0, 40.0, 70, "Good"));
        treeRepo.save(new DominantTree(birch, 18.0, 30.0, 40, "Moderate"));

        practiceRepo.save(new ForestManagementPractice("Mulching", "Apply organic mulch to reduce evaporation", 15.0, 200.0));
        practiceRepo.save(new ForestManagementPractice("Drip Irrigation", "Install drip irrigation system", 30.0, 1500.0));
        practiceRepo.save(new ForestManagementPractice("Thinning", "Selective thinning to reduce competition", 10.0, 300.0));

        balanceRepo.save(new SoilWaterBalance(LocalDate.now().minusDays(5), 10.0, 5.0, 0.0, 65.0));
        balanceRepo.save(new SoilWaterBalance(LocalDate.now().minusDays(4), 0.0, 6.0, 8.0, 60.0));
        balanceRepo.save(new SoilWaterBalance(LocalDate.now().minusDays(3), 15.0, 4.0, 0.0, 72.0));
        balanceRepo.save(new SoilWaterBalance(LocalDate.now().minusDays(2), 0.0, 7.0, 10.0, 58.0));
        balanceRepo.save(new SoilWaterBalance(LocalDate.now().minusDays(1), 5.0, 5.0, 0.0, 63.0));
        balanceRepo.save(new SoilWaterBalance(LocalDate.now(), 0.0, 6.0, 12.0, 55.0));
    }
}
