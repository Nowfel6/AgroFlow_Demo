package com.noppo.agroflow_noppo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal quantity_requested;
    private BigDecimal price_per_kg_requested;
    private String delivery_status;
    private String payment_mode_requested;
    private String bank_name;
    private String account_holder_name;
    private String account_number;
    private String ifsc_code;
    private  String online_banking_no;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id",nullable = false)
    @JsonBackReference("farmer-salerequest")
    private Farmer farmer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officer_id",nullable = false)
    @JsonBackReference("officer-salerequest")
    private KrishiOfficer officer;
    @OneToOne(mappedBy = "saleRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("salerequest-sale")
    private Sales sale;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "harvest_id", referencedColumnName = "id", unique = true)
    @JsonBackReference("harvest-salerequest")
    private Harvest harvest;
}
