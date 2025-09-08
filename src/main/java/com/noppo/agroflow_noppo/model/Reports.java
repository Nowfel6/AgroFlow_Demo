package com.noppo.agroflow_noppo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal total_yield;
    private BigDecimal total_area_cultivated;
    private String session_year;
    private String region;
    private Long no_of_farmer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officer_id",nullable = false)
    @JsonBackReference("officer-reports")
    private KrishiOfficer officer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id",nullable = false)
    @JsonBackReference("crop-reports")
    private Crop crop;
}
