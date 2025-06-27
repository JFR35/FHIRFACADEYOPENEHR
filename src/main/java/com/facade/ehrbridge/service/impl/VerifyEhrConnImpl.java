package com.facade.ehrbridge.service.impl;

import com.facade.ehrbridge.service.VerifyEhrConn;
import com.facade.ehrbridge.service.exception.EhrbaseConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VerifyEhrConnImpl implements VerifyEhrConn {

    private static final Logger logger = LoggerFactory.getLogger(VerifyEhrConn.class);

    @Value("${ehrbase.ping-endpoint}")
    private String pingEndpoint;

    private final RestTemplate restTemplate;
    private final String ehrBaseUrl;

    public VerifyEhrConnImpl(@Value("${ehrbase.url}") String ehrBaseUrl) {
        this.restTemplate = new RestTemplate();
        this.ehrBaseUrl = ehrBaseUrl;
    }

    @Override
    public boolean verifyEhrconn() {
        logger.info("Verificando conectividad con EHRbase en {}", pingEndpoint);
        try {
            String response = restTemplate.getForObject(pingEndpoint, String.class);
            logger.info("EHRbase respondió al ping con éxito.");
            return true;
        } catch (Exception e) {
            logger.error("No se pudo establecer conexión con EHRbase", e);
            throw new EhrbaseConnectionException("No se pudo establecer conexión con EHRbase en: " + pingEndpoint, e);
        }
    }
}
