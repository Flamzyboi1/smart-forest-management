package com.example.smartforest.controller;

import com.example.smartforest.service.IrrigationCostSavingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/irrigation")
public class IrrigationCostSavingController {

    private final IrrigationCostSavingService savingService;

    public IrrigationCostSavingController(IrrigationCostSavingService savingService) {
        this.savingService = savingService;
    }

    @GetMapping("/savings")
    public IrrigationCostSavingService.SavingResult calculateSavings(
            @RequestParam double baselineIrrigationMm,
            @RequestParam double waterCostPerMm,
            @RequestParam double areaHectares) {
        return savingService.calculateSavings(baselineIrrigationMm, waterCostPerMm, areaHectares);
    }
}
