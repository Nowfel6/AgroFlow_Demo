package com.noppo.agroflow_noppo.model;

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
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String average_duration;
    private String season;
    private String water_requirement;
    private String fertilizer_type;
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference("crop-cropplan")
    private List<CropPlan> cropPlans;
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference("crop-marketprice")
    private List<MarketPrice> marketPrices;
    @OneToMany(mappedBy = "crop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference("crop-reports")
    private List<Reports> reports;

}
