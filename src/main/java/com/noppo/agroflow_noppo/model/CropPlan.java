package com.noppo.agroflow_noppo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate planting_date;
    private LocalDate expected_harvest_date;
    private BigDecimal expected_yield;
    private String season;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id",nullable = false)
    @JsonBackReference("farmer-cropplan")
    private Farmer farmer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id",nullable = false)
    @JsonBackReference("crop-cropplan")
    private Crop crop;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id",nullable = false)
    @JsonBackReference("field-cropplan")
    private Field field;
    @OneToOne(mappedBy = "cropPlan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("cropplan-harvest")
    private Harvest harvest;
}
