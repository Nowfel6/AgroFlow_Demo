package com.noppo.agroflow_noppo.repo;
import com.noppo.agroflow_noppo.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestRepo extends JpaRepository<Harvest, Integer> {
    @Query("SELECT h FROM Harvest h WHERE h.cropPlan.farmer.id = :farmerId")
    List<Harvest> findAllByFarmerId(@Param("farmerId") Integer farmerId);
}