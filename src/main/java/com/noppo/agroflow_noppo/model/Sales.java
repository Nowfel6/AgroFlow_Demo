package com.noppo.agroflow_noppo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal final_quantity;
    private BigDecimal final_price_per_kg;
    private LocalDate sale_date;
    private String payment_status;
    private String payment_mode;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_request_id", referencedColumnName = "id")
    @JsonBackReference("salerequest-sale")// Or your request_id column name
    private SaleRequest saleRequest;

}
