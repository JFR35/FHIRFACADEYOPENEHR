package com.facade.ehrbridge.controller;

import com.facade.ehrbridge.service.VerifyEhrConnectionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ehrcomposition")
public class CompositionController {

    private final VerifyEhrConnectionUseCase verifyConnection;

    public CompositionController(VerifyEhrConnectionUseCase verifyConnection) {
        this.verifyConnection = verifyConnection;
    }

    @GetMapping("/verify-ehrbase")
    public ResponseEntity<String> verifyEhrbaseConnection() {
        if (verifyConnection.verifyConnection()) {
            return ResponseEntity.ok("Connection to Ehrbase successful!");
        } else {
            return ResponseEntity.status(500).body("Failed to connect to Ehrbase.");
        }
    }
}