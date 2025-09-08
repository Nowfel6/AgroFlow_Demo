package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.CropPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropPlanRepo extends JpaRepository<CropPlan, Integer> {
    List<CropPlan> findAllByFarmerId(Integer farmerId);
}