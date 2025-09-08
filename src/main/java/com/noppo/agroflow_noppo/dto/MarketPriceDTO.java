package com.noppo.agroflow_noppo.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class MarketPriceDTO {
    private int id;
    private String cropName; // We will flatten the structure
    private BigDecimal market_price_per_kg;
    private String effective_month;
    private String price_source;
    private String price_type;

    public MarketPriceDTO(int id, String cropName, BigDecimal market_price_per_kg, String effective_month, String price_source, String price_type) {
        this.id = id;
        this.cropName = cropName;
        this.market_price_per_kg = market_price_per_kg;
        this.effective_month = effective_month;
        this.price_source = price_source;
        this.price_type = price_type;
    }
}