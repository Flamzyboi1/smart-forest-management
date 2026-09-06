package com.example.smartforest.repository;

import com.example.smartforest.model.SoilWaterBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SoilWaterBalanceRepository extends JpaRepository<SoilWaterBalance, Long> {
    List<SoilWaterBalance> findByDateBetween(java.time.LocalDate start, java.time.LocalDate end);
}
