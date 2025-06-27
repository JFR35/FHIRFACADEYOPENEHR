package com.facade.ehrbridge.controller;


import com.facade.ehrbridge.service.VerifyEhrConn;
import com.facade.ehrbridge.service.exception.EhrbaseConnectionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ehr")
public class VerifyEhrConnController {

    private final VerifyEhrConn verifyEhrConn;

    public VerifyEhrConnController(VerifyEhrConn verifyEhrConn) {
        this.verifyEhrConn = verifyEhrConn;
    }

    @GetMapping("/verify-conn")
    public ResponseEntity<String> verifyConn() {
        try {
            verifyEhrConn.verifyEhrconn();
            return ResponseEntity.ok("Conexión exitosa con EHRbase.");
        } catch (EhrbaseConnectionException e) {
            return ResponseEntity.status(502).body("No se pudo conectar con EHRbase: " + e.getMessage());
        }
    }
}

