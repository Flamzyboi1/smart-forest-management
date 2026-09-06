package com.example.smartforest.controller;

import com.example.smartforest.model.SoilWaterBalance;
import com.example.smartforest.repository.SoilWaterBalanceRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/water-balance")
public class SoilWaterBalanceController {

    private final SoilWaterBalanceRepository balanceRepo;

    public SoilWaterBalanceController(SoilWaterBalanceRepository balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    @GetMapping
    public List<SoilWaterBalance> allBalances() {
        return balanceRepo.findAll();
    }

    @GetMapping("/range")
    public List<SoilWaterBalance> balancesByRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return balanceRepo.findByDateBetween(start, end);
    }
}
