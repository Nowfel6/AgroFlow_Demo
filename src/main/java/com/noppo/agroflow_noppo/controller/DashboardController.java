package com.noppo.agroflow_noppo.controller;

import com.noppo.agroflow_noppo.dto.DashboardDataDTO;
import com.noppo.agroflow_noppo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*") // Allow requests from your frontend
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public ResponseEntity<DashboardDataDTO> getDashboardData() {
        // Call the service to get the aggregated dashboard data
        DashboardDataDTO data = dashboardService.getDashboardData();

        // Return the data with a 200 OK status
        return ResponseEntity.ok(data);
    }
}
