package com.noppo.agroflow_noppo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String landmark;
    private String soil_type;
    private String irrigation_type;
    private BigDecimal size;
    private String ownership_type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id",nullable = false)
    @JsonBackReference("farmer-field")
    private Farmer farmer;
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference("field-cropplan")
    private List<CropPlan> cropPlans;
}
