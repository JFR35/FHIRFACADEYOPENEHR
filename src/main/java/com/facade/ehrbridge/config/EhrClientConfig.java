package com.facade.ehrbridge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

/**
 * Construir caveceras HTTP autenticadas hacia el server EHRbase
 * para consumir la API de EHRbase con credenciales incluidos
 */
@Configuration(proxyBeanMethods = false)
public class EhrClientConfig {

    @Value("${ehrbase.username}")
    private String ehrBaseUsername;

    @Value("${ehrbase.password}")
    private String ehrBasePassword;

    /**
     * Crea e inyecta un {@link RestTemplate} con un interceptor configurado
     * para aplicar autenticación básica en cada request saliente.
     *
     * @return instancia de {@link RestTemplate} preconfigurada.
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(authInterceptor());
        return restTemplate;
    }


    /**
     * Crea un {@link ClientHttpRequestInterceptor} que añade cabecera Authorization
     * con esquema Basic para autenticarse contra el endpoint de EHRbase.
     *
     * @return interceptor de autenticación básica.
     */
    private ClientHttpRequestInterceptor authInterceptor() {
        return (request, body, execution) -> {
            String auth = ehrBaseUsername + ":" + ehrBasePassword;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            request.getHeaders().add("Authorization", "Basic " + encodedAuth);
            return execution.execute(request, body);
        };
    }
}
