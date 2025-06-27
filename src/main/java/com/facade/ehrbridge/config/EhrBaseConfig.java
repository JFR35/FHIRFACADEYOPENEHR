package com.facade.ehrbridge.config;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClient;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.openehr.sdk.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.openehr.sdk.webtemplate.templateprovider.FileBasedTemplateProvider;
import org.ehrbase.openehr.sdk.webtemplate.templateprovider.TemplateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
@Configuration
public class EhrBaseConfig {

    @Value("${ehrbase.url}")
    private String ehrBaseUrl;

    @Value("${ehrbase.username}")
    private String ehrBaseUsername;

    @Value("${ehrbase.password}")
    private String ehrBasePassword;

    @Value("${ehrbase.templates.path}")
    private String templatesPath;

    @Bean
    public OpenEhrClientConfig openEhrClientConfig() {
        return new OpenEhrClientConfig(URI.create(ehrBaseUrl));
    }
    @Bean
    public OpenEhrClient openEhrClient(OpenEhrClientConfig config, TemplateProvider templateProvider) {
        // Configura autenticación básica
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(ehrBaseUsername, ehrBasePassword)
        );

        HttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();

        return new DefaultRestClient(config, templateProvider, httpClient);
    }

    @Bean
    public TemplateProvider templateProvider() {
        return new FileBasedTemplateProvider(Paths.get(templatesPath));
    }
}