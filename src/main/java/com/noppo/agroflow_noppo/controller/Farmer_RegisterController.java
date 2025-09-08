package com.noppo.agroflow_noppo.controller;

import com.noppo.agroflow_noppo.dto.FarmerProfileDTO;
import com.noppo.agroflow_noppo.model.Farmer;
import com.noppo.agroflow_noppo.service.FarmerProfileService;
import com.noppo.agroflow_noppo.service.Farmer_RegisterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
@CrossOrigin(origins = "*")
public class Farmer_RegisterController {

    @Autowired
    private Farmer_RegisterService farmerService;
    @Autowired
    private FarmerProfileService farmerProfileService;

    @PostMapping("/register")
    public ResponseEntity<?> registerFarmer(@RequestBody Farmer farmer) {
        try {
            Farmer newFarmer = farmerService.registerFarmer(farmer);
            return new ResponseEntity<>(newFarmer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    // --- NEW ENDPOINT 1: Get all farmers for an officer ---
    @GetMapping("/officer/{officerId}")
    public ResponseEntity<List<Farmer>> getFarmersForOfficer(@PathVariable Integer officerId) {
        List<Farmer> farmers = farmerService.getFarmersByOfficerId(officerId);
        return ResponseEntity.ok(farmers);
    }

    // --- NEW ENDPOINT 2: Search farmers ---
    @GetMapping("/search")
    public ResponseEntity<List<Farmer>> searchFarmers(
            @RequestParam Integer officerId,
            @RequestParam String name) {
        List<Farmer> farmers = farmerService.searchFarmersByNameForOfficer(officerId, name);
        return ResponseEntity.ok(farmers);
    }
    // ... inside your FarmerController class ...

    // --- NEW ENDPOINT TO GET A FARMER'S PROFILE ---
    @GetMapping("/{farmerId}/profile")
    public ResponseEntity<FarmerProfileDTO> getFarmerProfile(@PathVariable Integer farmerId) {
        try {
            FarmerProfileDTO profile = farmerProfileService.getFarmerProfileById(farmerId);
            return ResponseEntity.ok(profile);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}