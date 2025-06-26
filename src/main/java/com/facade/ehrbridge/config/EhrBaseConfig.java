package com.facade.ehrbridge.config;

import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClient;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.openehr.sdk.client.openehrclient.defaultrestclient.DefaultRestClient;
// import org.ehrbase.openehr.sdk.webtemplate.templateprovider.FileBasedTemplateProvider; // No necesario
// import org.ehrbase.openehr.sdk.webtemplate.templateprovider.TemplateProvider; // No necesario
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration(proxyBeanMethods = false)
public class EhrBaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(EhrBaseConfig.class);

    /**
     * URL del servidor EHRbase inyectada desde el archivo de properties
     */
    @Value("${ehrbase.url}")
    private String ehrBaseUrl;

    /**
     * Crea una instancia de {@link  OpenEhrClient} utilizando la URL configurada.
     * @return cliente OpenEHR configurado con {@link DefaultRestClient}
     * @throws RuntimeException si ocurre un error al inicializar el cliente.
     */
    @Bean
    public OpenEhrClient openEhrClient() {
        try {
            OpenEhrClientConfig config = new OpenEhrClientConfig(URI.create(ehrBaseUrl));
            return new DefaultRestClient(config);
        } catch (Exception e) {
            logger.error("Error inicializando OpenEhrClient: {}", e.getMessage(), e);
            throw new RuntimeException("Error inicializando OpenEhrClient", e);
        }
    }
}