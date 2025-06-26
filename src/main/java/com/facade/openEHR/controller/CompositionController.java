package com.facade.openEHR.controller;
import com.facade.openEHR.service.implementacion.VerifyEhrConnectionUseCaseImpl;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ehrcomposition")
public class CompositionController {

    private final VerifyEhrConnectionUseCaseImpl verifyConnection;

    public CompositionController(VerifyEhrConnectionUseCaseImpl verifyConnection) {
        this.verifyConnection = verifyConnection;
    }

    // Endpoint para verificar la conexión con Ehrbase
    @GetMapping("/verify-ehrbase")
    public ResponseEntity<String> verifyEhrbaseConnection() {
        if (verifyConnection.verifyConnection()) {
            return ResponseEntity.ok("Connection to Ehrbase successful!");
        } else {
            return ResponseEntity.status(500).body("Failed to connect to Ehrbase.");
        }
    }
}
