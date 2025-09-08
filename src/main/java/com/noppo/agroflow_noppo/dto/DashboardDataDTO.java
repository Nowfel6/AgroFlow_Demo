package com.noppo.agroflow_noppo.dto;

import com.noppo.agroflow_noppo.model.CropCalendar;
import com.noppo.agroflow_noppo.model.FertilizerRecommendation;
import com.noppo.agroflow_noppo.model.MarketPrice;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDataDTO {

    private List<MarketPriceDTO> marketPrices;
    private List<CropCalendar> cropCalendars;
    private List<FertilizerRecommendation> fertilizerRecommendations;

    // We can also add the stats here later
    // private long totalFarmers;
    // private long activeCropPlans;
}