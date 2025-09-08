package com.noppo.agroflow_noppo.service;

import com.noppo.agroflow_noppo.dto.FarmerProfileDTO;
import com.noppo.agroflow_noppo.model.*;
import com.noppo.agroflow_noppo.repo.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FarmerProfileService {

    // Inject all the necessary repositories
    @Autowired private FarmerRepo farmerRepository;
    @Autowired private FieldRepo fieldRepository;
    @Autowired private CropPlanRepo cropPlanRepository;
    @Autowired private HarvestRepo harvestRepository;
    @Autowired private SalesRepo salesRepository;
    // ... your other autowired fields and existing methods ...

    // --- NEW METHOD TO GET THE FULL FARMER PROFILE ---
    @Transactional(readOnly = true)
    public FarmerProfileDTO getFarmerProfileById(Integer farmerId) {
        // 1. Fetch the core farmer object
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new EntityNotFoundException("Farmer not found with ID: " + farmerId));

        // 2. Fetch all related lists using the new repository methods
        List<Field> fields = fieldRepository.findAllByFarmerId(farmerId);
        List<CropPlan> cropPlans = cropPlanRepository.findAllByFarmerId(farmerId);
        List<Harvest> harvests = harvestRepository.findAllByFarmerId(farmerId);
        List<Sales> sales = salesRepository.findAllByFarmerId(farmerId);
        // Use map() to get a Stream<BigDecimal> and then reduce() to sum them.
        BigDecimal totalAcres = fields.stream()
                .map(Field::getSize) // This creates a Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Start with 0 and add each value


        // Count how many crop plans have the status "Ongoing"
        long activeCropPlans = cropPlans.stream()
                .filter(plan -> "Ongoing".equalsIgnoreCase(plan.getStatus()))
                .count();

        // Calculate total sales revenue by summing the 'final_quantity' * 'final_price_per_kg'
        BigDecimal totalSalesValue = sales.stream()
                .map(sale -> sale.getFinal_quantity().multiply(sale.getFinal_price_per_kg()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        // 3. Create and populate the DTO
        FarmerProfileDTO profileDTO = new FarmerProfileDTO();
        profileDTO.setId(farmer.getId());
        profileDTO.setName(farmer.getName());
        profileDTO.setContact(farmer.getContact());
        profileDTO.setNid(farmer.getNid());
        profileDTO.setVillage(farmer.getVillage());
        profileDTO.setUnion_name(farmer.getUnion_name());
        profileDTO.setDistrict(farmer.getDistrict());
        profileDTO.setTotalAcres(totalAcres.doubleValue());
        profileDTO.setActiveCropPlans(activeCropPlans);
        profileDTO.setTotalSalesYTD(totalSalesValue);
        profileDTO.setFields(fields);
        profileDTO.setCropPlans(cropPlans);
        profileDTO.setHarvests(harvests);
        profileDTO.setSales(sales);

        return profileDTO;
    }
}