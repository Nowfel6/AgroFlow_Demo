package com.noppo.agroflow_noppo.repo;

import com.noppo.agroflow_noppo.model.CropCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropCalendarRepo extends JpaRepository<CropCalendar, Integer> {
    // This interface is intentionally empty for now.
    // JpaRepository gives us findAll(), findById(), save(), etc. for free.
}