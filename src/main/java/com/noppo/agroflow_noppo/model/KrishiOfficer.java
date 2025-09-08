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
public class KrishiOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String nid;
    private String contact;
    private String office_location;
    private String region_assigned;
    private String password;
    @OneToMany(mappedBy = "officer" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonManagedReference("officer-farmer")
    private List<Farmer> registeredFarmers;
    @OneToMany(mappedBy = "officer" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonManagedReference("officer-salerequest")
    private List<SaleRequest> saleRequests;
    @OneToMany(mappedBy = "officer" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonManagedReference("officer-reports")
    private List<Reports> reports;
}
