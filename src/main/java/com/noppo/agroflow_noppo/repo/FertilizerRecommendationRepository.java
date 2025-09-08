package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.FertilizerRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FertilizerRecommendationRepository extends JpaRepository<FertilizerRecommendation, Integer> {
    // This interface remains empty for now.
    // By extending JpaRepository, we automatically get all standard CRUD methods
    // like findAll(), save(), findById(), etc.
}