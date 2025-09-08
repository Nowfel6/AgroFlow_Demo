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
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate harvest_date;
    private BigDecimal quantity;
    private String quality_grade;
    private String storage_status;
    private String storage_location;
    @OneToOne(mappedBy = "harvest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("harvest-salerequest")
    private SaleRequest salesRequest;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cropPlan_id", referencedColumnName = "id", unique = true)
    @JsonBackReference("cropplan-harvest")
    private CropPlan cropPlan;
}
