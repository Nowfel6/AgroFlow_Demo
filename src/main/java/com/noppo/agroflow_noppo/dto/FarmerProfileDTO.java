package com.noppo.agroflow_noppo.dto;

import com.noppo.agroflow_noppo.model.*; // Import all your model classes
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FarmerProfileDTO {
    // Basic Farmer Info
    private Integer id;
    private String name;
    private String contact;
    private String nid;
    private String village;
    private String union_name;
    private String district;
    private Double totalAcres;
    private Long activeCropPlans;
    private BigDecimal totalSalesYTD;
    // Related Lists
    private List<Field> fields;
    private List<CropPlan> cropPlans;
    private List<Harvest> harvests;
    private List<Sales> sales;

    // You can add more calculated stats here later if needed
}