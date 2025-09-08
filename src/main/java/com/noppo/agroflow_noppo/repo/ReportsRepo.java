package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepo extends JpaRepository<Reports, Integer> {
}