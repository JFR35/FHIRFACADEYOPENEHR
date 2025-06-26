package com.facade.ehrbridge.service.impl;

import com.facade.ehrbridge.aqlqueries.Aql;
import com.facade.ehrbridge.config.EhrBaseHeaderUtil;
import com.facade.ehrbridge.exception.EhrServiceException;
import com.facade.ehrbridge.service.GetCompositionsByEhrId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GetCompositionsByEhrIdImpl implements GetCompositionsByEhrId {

    private static final Logger logger = LoggerFactory.getLogger(GetCompositionsByEhrIdImpl.class);

    private final RestTemplate restTemplate;
    private final EhrBaseHeaderUtil ehrBaseHeaderUtil;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${ehrbase.url}")
    private String ehrBaseUrl;

    public GetCompositionsByEhrIdImpl(RestTemplate restTemplate, EhrBaseHeaderUtil ehrBaseHeaderUtil) {
        this.restTemplate = restTemplate;
        this.ehrBaseHeaderUtil = ehrBaseHeaderUtil;
    }

    @Override
    public List<String> getCompositionsEhrId(String ehrId) {
        try {
            validateAndParseUUID(ehrId, "EHR ID");
            String aqlQuery = String.format(Aql.COMPOSITIONS_BY_EHR_ID, ehrId);
            HttpHeaders headers = ehrBaseHeaderUtil.createAuthenticatedHeaders();
            HttpEntity<String> request = new HttpEntity<>(aqlQuery, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    ehrBaseUrl + "/rest/openehr/v1/query/aql",
                    HttpMethod.POST,
                    request,
                    String.class
            );

            JsonNode result = objectMapper.readTree(response.getBody());
            List<String> compositions = new ArrayList<>();
            JsonNode rows = result.path("rows");
            for (JsonNode row : rows) {
                compositions.add(row.get(0).asText());
            }
            return compositions;
        } catch (Exception e) {
            logger.error("Error retrieving compositions for ehrId {}: {}", ehrId, e.getMessage());
            throw new EhrServiceException("Failed to retrieve compositions for ehrId: " + ehrId, e);
        }
    }

    private UUID validateAndParseUUID(String uuid, String fieldName) {
        try {
            return UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            logger.error("Invalid {}: {}", fieldName, uuid);
            throw new IllegalArgumentException("Invalid " + fieldName + " format");
        }
    }
}
