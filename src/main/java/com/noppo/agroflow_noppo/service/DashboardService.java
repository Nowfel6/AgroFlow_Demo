package com.noppo.agroflow_noppo.service;

import com.noppo.agroflow_noppo.dto.DashboardDataDTO;
import com.noppo.agroflow_noppo.dto.MarketPriceDTO;
import com.noppo.agroflow_noppo.model.CropCalendar;
import com.noppo.agroflow_noppo.model.FertilizerRecommendation;
import com.noppo.agroflow_noppo.model.MarketPrice;
import com.noppo.agroflow_noppo.repo.FertilizerRecommendationRepository;
import com.noppo.agroflow_noppo.repo.CropCalendarRepo;
import com.noppo.agroflow_noppo.repo.FertilizerRecommendationRepository;
import com.noppo.agroflow_noppo.repo.MarketPriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DashboardService {

    private final MarketPriceRepo marketPriceRepository;
    private final CropCalendarRepo cropCalendarRepository;
    private final FertilizerRecommendationRepository fertilizerRecommendationRepository;

    // Use constructor injection for all the required repositories
    @Autowired
    public DashboardService(MarketPriceRepo marketPriceRepository,
                            CropCalendarRepo cropCalendarRepository,
                            FertilizerRecommendationRepository fertilizerRecommendationRepository) {
        this.marketPriceRepository = marketPriceRepository;
        this.cropCalendarRepository = cropCalendarRepository;
        this.fertilizerRecommendationRepository = fertilizerRecommendationRepository;
    }

    @Transactional(readOnly = true) // Important for performance and lazy loading
    public DashboardDataDTO getDashboardData() {
        // 1. Fetch all data from each repository
        List<MarketPrice> prices = marketPriceRepository.findAll();
        List<CropCalendar> calendars = cropCalendarRepository.findAll();
        List<FertilizerRecommendation> recommendations = fertilizerRecommendationRepository.findAll();

        // 2. MAP the entities to DTOs
        List<MarketPriceDTO> marketPriceDTOs = prices.stream()
                .map(price -> new MarketPriceDTO(
                        price.getId(),
                        price.getCrop().getName(), // This is where the lazy loading is safely triggered
                        price.getMarket_price_per_kg(),
                        price.getEffective_month(),
                        price.getPrice_source(),
                        price.getPrice_type()
                ))
                .collect(Collectors.toList());

//        List<CropCalendarDTO> cropCalendarDTOs = calendars.stream()
//                .map(cal -> new CropCalendarDTO(
//                        cal.getId(),
//                        cal.getName(),
//                        cal.getSowingSeason(),
//                        cal.getHarvestSeason()
//                ))
//                .collect(Collectors.toList());

        // 3. Create a new DTO instance and populate it with the DTO lists
        DashboardDataDTO dashboardData = new DashboardDataDTO();
        dashboardData.setMarketPrices(marketPriceDTOs);
        dashboardData.setCropCalendars(calendars);
        dashboardData.setFertilizerRecommendations(recommendations);

        return dashboardData;
    }
}