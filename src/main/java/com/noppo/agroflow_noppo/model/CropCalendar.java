package com.noppo.agroflow_noppo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Using Long is a best practice for IDs

    @Column(nullable = false)
    private String name; // e.g., "Potato"

    @Column(nullable = false)
    private String sowingSeason; // e.g., "June - July"

    @Column(nullable = false)
    private String harvestSeason; // e.g., "November - December"

     // e.g., "fas fa-seedling"
}