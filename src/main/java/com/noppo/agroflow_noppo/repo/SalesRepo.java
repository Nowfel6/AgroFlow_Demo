package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Integer> {
    @Query("SELECT s FROM Sales s WHERE s.saleRequest.farmer.id = :farmerId")
    List<Sales> findAllByFarmerId(@Param("farmerId") Integer farmerId);
}