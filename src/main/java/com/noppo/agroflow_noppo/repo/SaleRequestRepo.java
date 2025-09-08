package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.SaleRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRequestRepo extends JpaRepository<SaleRequest, Integer> {
}