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
public class MarketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String effective_month;
    private BigDecimal market_price_per_kg;
    private String price_source;
    private String price_type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id",nullable = false)
    @JsonBackReference("crop-marketprice")
    private Crop crop;
}
