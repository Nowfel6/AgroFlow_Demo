package com.noppo.agroflow_noppo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FertilizerRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String cropName; // The crop this recommendation is for, e.g., "Rice (Boro)"

    @Column(nullable = false)
    private String fertilizerName; // The name of the fertilizer, e.g., "Urea", "NPK (10-26-26)"

    @Column(nullable = false)
    private String applicationTiming; // When to apply it, e.g., "Basal Application", "During Sowing"

    @Column(nullable = false)
    private String dosage; // The recommended amount, e.g., "120 kg", "150 kg"

    // Optional: A field to add extra notes or specify the unit more clearly
    private String dosageUnit; // e.g., "per Hectare"
}