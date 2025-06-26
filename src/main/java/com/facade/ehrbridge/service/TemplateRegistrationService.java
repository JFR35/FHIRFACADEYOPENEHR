package com.facade.ehrbridge.service;
/*
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClient;
import org.ehrbase.openehr.sdk.webtemplate.templateprovider.FileBasedTemplateProvider;
import org.ehrbase.openehr.sdk.webtemplate.model.WebTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TemplateRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(TemplateRegistrationService.class);

    private final OpenEhrClient openEhrClient;
    private final FileBasedTemplateProvider templateProvider;

    public TemplateRegistrationService(OpenEhrClient openEhrClient, FileBasedTemplateProvider templateProvider) {
        this.openEhrClient = openEhrClient;
        this.templateProvider = templateProvider;
    }

    @PostConstruct
    public void registerTemplates() {
        templateProvider.stream().forEach(template -> {
            String templateId = template.getTemplateId();
            try {
                openEhrClient.templateEndpoint().ensureExistence(templateId);
                logger.info("Template '{}' registrado correctamente en EhrBase", templateId);
            } catch (Exception e) {
                logger.error("Error registrando template '{}': {}", templateId, e.getMessage(), e);
            }
        });
    }
}
*/