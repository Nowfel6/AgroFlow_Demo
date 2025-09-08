package com.noppo.agroflow_noppo.service;

import com.noppo.agroflow_noppo.model.Farmer;
import com.noppo.agroflow_noppo.model.KrishiOfficer;
import com.noppo.agroflow_noppo.repo.FarmerRepo;
import com.noppo.agroflow_noppo.repo.OfficerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Farmer_RegisterService {
    @Autowired
    private FarmerRepo farmerRepository;

    @Autowired
    private OfficerRepo officerRepository; // You need this to verify the officer exists

    public Farmer registerFarmer(Farmer farmer) {
        // Important: The incoming 'farmer' object has an 'officer' with only an ID.
        // We need to make sure this officer actually exists in the database.
        KrishiOfficer officer = officerRepository.findById(farmer.getOfficer().getId())
                .orElseThrow(() -> new RuntimeException("Officer not found with ID: " + farmer.getOfficer().getId()));

        // Now that we have the full officer object, set it on the farmer
        farmer.setOfficer(officer);

        // Save the new farmer to the database
        return farmerRepository.save(farmer);
    }
    // --- NEW METHOD 1: Get all farmers for an officer ---
    public List<Farmer> getFarmersByOfficerId(Integer officerId) {
        return farmerRepository.findAllByOfficerId(officerId);
    }

    // --- NEW METHOD 2: Search farmers for an officer ---
    public List<Farmer> searchFarmersByNameForOfficer(Integer officerId, String name) {
        return farmerRepository.findByOfficerIdAndNameContainingIgnoreCase(officerId, name);
    }
}
