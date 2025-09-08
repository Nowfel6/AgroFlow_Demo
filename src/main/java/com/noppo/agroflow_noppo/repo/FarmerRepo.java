package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Integer> {
    List<Farmer> findAllByOfficerId(Integer officerId);

    // Method 2: Search for farmers by name, but only for a specific officer.
    // We use a custom JPQL query for this.
    @Query("SELECT f FROM Farmer f WHERE f.officer.id = :officerId AND LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Farmer> findByOfficerIdAndNameContainingIgnoreCase(
            @Param("officerId") Integer officerId,
            @Param("name") String name
    );
}
