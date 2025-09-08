package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.KrishiOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepo extends JpaRepository<KrishiOfficer,Integer> {
     Optional<KrishiOfficer> findByEmail(String email);
}
