package com.facade.ehrbridge.service;

/*
import com.facade.ehrbridge.exception.EhrServiceException;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClient;
import org.ehrbase.openehr.sdk.webtemplate.templateprovider.TemplateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

// esta clase está diseñada para registrar templates en EHRbase programáticamente al iniciar la aplicación Spring Boot
@Service
public class TemplateRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(TemplateRegistrationService.class);
    private static final String TEMPLATE_ID = "patient_visit";

    private final OpenEhrClient openEhrClient;
    private final TemplateProvider templateProvider;

    public TemplateRegistrationService(OpenEhrClient openEhrClient, TemplateProvider templateProvider) {
        this.openEhrClient = openEhrClient;
        this.templateProvider = templateProvider;
    }

    @PostConstruct
    public void registerTemplates() {
        try {
            if (templateProvider.find(TEMPLATE_ID).isPresent()) {
                openEhrClient.templateEndpoint().ensureExistence(TEMPLATE_ID);
                logger.info("Template '{}' registrado correctamente", TEMPLATE_ID);
            } else {
                logger.warn("Template '{}' no encontrado en el proveedor", TEMPLATE_ID);
            }
        } catch (Exception e) {
            logger.error("Error al registrar el template '{}': {}", TEMPLATE_ID, e.getMessage());
            throw new EhrServiceException("Error registrando el template", e);
        }
    }
}
 */
