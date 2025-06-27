package com.facade.ehrbridge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class EhrBaseHeaderUtil {

    /**
     * Nombre de usuario para auth del servidor EHRbase
     * inyectado desde la propierdad {@code ehrbase.username}
     */
    @Value("${ehrbase.username}")
    private String ehrBaseUsername;

    /**
     * Contraseña autenticación del servidor EHRbase
     * inyectado desde la propierdad {@code ehrbase.password}
     */
    @Value("${ehrbase.password}")
    private String ehrBasePassword;

    /**
     * Construye las cabeceras HTTP para enviar peticiones autenticadas
     * Incluye la cabecera de tipo {@code Content-Type: application/json}
     * Contiene la autenticación básica
     * @return una instancia {@link HttpHeaders } con auth
     */
    public HttpHeaders createAuthenticatedHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(ehrBaseUsername, ehrBasePassword);
        return headers;
    }
}
