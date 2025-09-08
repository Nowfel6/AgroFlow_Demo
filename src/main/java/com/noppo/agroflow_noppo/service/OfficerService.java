package com.noppo.agroflow_noppo.service;
import com.noppo.agroflow_noppo.dto.LoginRequest;
import com.noppo.agroflow_noppo.model.KrishiOfficer;
import com.noppo.agroflow_noppo.repo.OfficerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficerService {
    @Autowired
   private OfficerRepo repo;

    public KrishiOfficer addOfficer(KrishiOfficer officer) {
        return repo.save(officer);
    }

    public KrishiOfficer loginOfficer(LoginRequest loginRequest) {
        // 1. Find the officer by the provided email.
        Optional<KrishiOfficer> officerOptional = repo.findByEmail(loginRequest.getEmail());

        // 2. Check if the officer exists.
        if (officerOptional.isEmpty()) {
            // Throw an error if no user is found with that email.
            // Use a generic message for security to not reveal if the email was right or wrong.
            throw new IllegalStateException("Invalid email or password");
        }

        KrishiOfficer officer = officerOptional.get();

        // 3. Compare the plain text passwords.
        String providedPassword = loginRequest.getPassword();
        String storedPassword = officer.getPassword();

        if (providedPassword.equals(storedPassword)) {
            // If the passwords match, the login is successful. Return the officer object.
            return officer;
        } else {
            // If passwords do not match, throw the same error.
            throw new IllegalStateException("Invalid email or password");
        }
    }
}
