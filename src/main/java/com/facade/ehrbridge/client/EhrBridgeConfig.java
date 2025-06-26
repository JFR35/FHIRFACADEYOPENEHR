package com.facade.ehrbridge.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Configuration
public class EhrBridgeConfig {

    @Value("${ehrbase.username}")
    private String ehrBaseUsername;

    @Value("${ehrbase.password}")
    private String ehrBasePassword;

    // Bean para RestTemplate con autenticación básica
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(createAuthInterceptor());
        return restTemplate;
    }

    private ClientHttpRequestInterceptor createAuthInterceptor() {
        return (request, body, execution) -> {
            String auth = ehrBaseUsername + ":" + ehrBasePassword;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            request.getHeaders().add("Authorization", "Basic " + encodedAuth);
            return execution.execute(request, body);
        };
    }
}