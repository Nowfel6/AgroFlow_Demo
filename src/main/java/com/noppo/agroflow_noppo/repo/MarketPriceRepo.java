package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.MarketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketPriceRepo extends JpaRepository<MarketPrice, Integer> {
}