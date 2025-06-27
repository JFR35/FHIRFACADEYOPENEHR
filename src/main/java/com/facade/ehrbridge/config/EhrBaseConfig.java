package com.facade.ehrbridge.config;

import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClient;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.openehr.sdk.client.openehrclient.defaultrestclient.DefaultRestClient;
// import org.ehrbase.openehr.sdk.webtemplate.templateprovider.FileBasedTemplateProvider; // No necesario
// import org.ehrbase.openehr.sdk.webtemplate.templateprovider.TemplateProvider; // No necesario
import org.ehrbase.openehr.sdk.webtemplate.templateprovider.FileBasedTemplateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.nio.file.Paths;

@Configuration(proxyBeanMethods = false)
public class EhrBaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(EhrBaseConfig.class);

    /**
     * URL del servidor EHRbase inyectada desde el archivo de properties
     */
    @Value("${ehrbase.url}")
    private String ehrBaseUrl;
    @Value("${ehrbase.rest.path}")
    private String restPath;

    /**
     * Crea una instancia de {@link  OpenEhrClient} utilizando la URL configurada.
     * @return cliente OpenEHR configurado con {@link DefaultRestClient}
     * @throws RuntimeException si ocurre un error al inicializar el cliente.
     */
    @Bean
    public OpenEhrClient openEhrClient() {
        try {
            // Construye la URL completa correctamente
            String fullUrl = ehrBaseUrl + restPath;

            OpenEhrClientConfig config = new OpenEhrClientConfig(URI.create(fullUrl));
            return new DefaultRestClient(config);
        } catch (Exception e) {
            throw new RuntimeException("Error configuring EHRbase client", e);
        }
    }

}