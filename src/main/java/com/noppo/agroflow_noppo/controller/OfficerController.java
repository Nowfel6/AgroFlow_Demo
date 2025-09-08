package com.noppo.agroflow_noppo.controller;

import com.noppo.agroflow_noppo.dto.LoginRequest;
import com.noppo.agroflow_noppo.model.KrishiOfficer;
import com.noppo.agroflow_noppo.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OfficerController {
    @Autowired
   private OfficerService service;

   @PostMapping("/signup")
    public ResponseEntity<?> addOfficer(@RequestBody KrishiOfficer officer){
        try {
            KrishiOfficer nwofficer = service.addOfficer(officer);
            return new ResponseEntity<>(nwofficer, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginOfficer(@RequestBody LoginRequest loginRequest){
        try {
            KrishiOfficer officer = service.loginOfficer(loginRequest);

            // On successful login, return the officer's data.
            // It's a good practice to never send the password back to the client.
            officer.setPassword(null);

            return ResponseEntity.ok(officer);
        } catch (IllegalStateException e) {
            // This catches the "Invalid email or password" error from the service.
            // 401 Unauthorized is the correct HTTP status for a failed login.
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
