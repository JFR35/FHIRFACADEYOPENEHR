package com.facade.ehrbridge.config;

import org.ehrbase.openehr.sdk.webtemplate.templateprovider.FileBasedTemplateProvider;
import org.ehrbase.openehr.sdk.webtemplate.templateprovider.TemplateProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration(proxyBeanMethods = false)
public class TemplateConfig {

    @Value("${ehrbase.templates.path}")
    private String templatesPath;

    @Bean
    public TemplateProvider templateProvider() {
        return new FileBasedTemplateProvider(Paths.get(templatesPath));
    }
}
