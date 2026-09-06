package com.example.smartforest.service;

import com.example.smartforest.model.ForestManagementPractice;
import com.example.smartforest.repository.ForestManagementPracticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IrrigationCostSavingService {

    private final ForestManagementPracticeRepository practiceRepo;

    public IrrigationCostSavingService(ForestManagementPracticeRepository practiceRepo) {
        this.practiceRepo = practiceRepo;
    }

    public static class SavingResult {
        public double baselineWaterMm;
        public double optimizedWaterMm;
        public double waterSavedMm;
        public double waterSavedPercent;
        public double baselineCost;
        public double optimizedCost;
        public double costSaved;
        public double costSavedPercent;
        public List<ForestManagementPractice> recommendedPractices;

        public SavingResult(double baselineWaterMm, double optimizedWaterMm,
                            double baselineCost, double optimizedCost,
                            List<ForestManagementPractice> practices) {
            this.baselineWaterMm = baselineWaterMm;
            this.optimizedWaterMm = optimizedWaterMm;
            this.waterSavedMm = baselineWaterMm - optimizedWaterMm;
            this.waterSavedPercent = (baselineWaterMm > 0) ? (waterSavedMm / baselineWaterMm) * 100.0 : 0.0;
            this.baselineCost = baselineCost;
            this.optimizedCost = optimizedCost;
            this.costSaved = baselineCost - optimizedCost;
            this.costSavedPercent = (baselineCost > 0) ? (costSaved / baselineCost) * 100.0 : 0.0;
            this.recommendedPractices = practices;
        }
    }

    public SavingResult calculateSavings(double baselineIrrigationMm,
                                         double waterCostPerMm,
                                         double areaHectares) {
        List<ForestManagementPractice> practices = practiceRepo.findAll();

        double totalWaterSavingPercent = 0.0;
        double totalCostPerHectare = 0.0;

        for (ForestManagementPractice p : practices) {
            totalWaterSavingPercent += p.getWaterSavingPercent();
            totalCostPerHectare += p.getCostPerHectare();
        }

        // Cap total saving at a reasonable max (e.g., 60%)
        totalWaterSavingPercent = Math.min(totalWaterSavingPercent, 60.0);

        double optimizedWaterMm = baselineIrrigationMm * (1.0 - totalWaterSavingPercent / 100.0);

        double baselineCost = baselineIrrigationMm * waterCostPerMm * areaHectares;
        double optimizedCost = optimizedWaterMm * waterCostPerMm * areaHectares + totalCostPerHectare * areaHectares;

        return new SavingResult(baselineIrrigationMm, optimizedWaterMm, baselineCost, optimizedCost, practices);
    }
}
