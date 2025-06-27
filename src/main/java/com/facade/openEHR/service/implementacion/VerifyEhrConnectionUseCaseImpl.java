package com.facade.openEHR.service.implementacion;

import com.facade.openEHR.service.VerifyEhrConnectionUseCase;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VerifyEhrConnectionUseCaseImpl implements VerifyEhrConnectionUseCase {


    private static final Logger logger = LoggerFactory.getLogger(EhrBaseService.class);
    private final OpenEhrClient openEhrClient;

    public VerifyEhrConnectionUseCaseImpl(OpenEhrClient openEhrClient) {
        this.openEhrClient = openEhrClient;
    }

    @Override
    public boolean verifyConnection() {

        try {
            openEhrClient.ehrEndpoint().getEhrStatus(UUID.randomUUID());
            return true;
        } catch (Exception e) {
            logger.error("Failed to connect to EHRbase or authentication issue: {}", e.getMessage());
            return false;
        }
    }
}
