package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepo extends JpaRepository<Crop, Integer> {
}