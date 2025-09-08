package com.noppo.agroflow_noppo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nid;
    private String contact;
    private String district;
    private String union_name;
    private String village;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officer_id",nullable = false)
    @JsonBackReference("officer-farmer")
    private KrishiOfficer officer;
    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference("farmer-cropplan")
    private List<CropPlan> cropPlans;
    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference("farmer-field")
    private List<Field> fields;
    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference("farmer-salerequest")
    private List<SaleRequest> saleRequests;
}
