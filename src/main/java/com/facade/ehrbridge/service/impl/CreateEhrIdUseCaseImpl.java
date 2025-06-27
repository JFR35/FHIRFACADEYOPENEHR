package com.facade.ehrbridge.service.impl;


import com.facade.ehrbridge.service.CreateEhrIdUseCase;
import org.ehrbase.openehr.sdk.client.openehrclient.EhrEndpoint;
import org.ehrbase.openehr.sdk.client.openehrclient.OpenEhrClient;
import org.ehrbase.openehr.sdk.util.exception.WrongStatusCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CreateEhrIdUseCaseImpl implements CreateEhrIdUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CreateEhrIdUseCaseImpl.class);

    private final OpenEhrClient openEhrClient;

    public CreateEhrIdUseCaseImpl(OpenEhrClient openEhrClient) {
        this.openEhrClient = openEhrClient;
    }

    /*
        @Override
        public String createNewEhr() {
            return openEhrClient.ehrEndpoint().createEhr().toString();
        }

     */
    //El SDK permite pasar ExternalEhrId, SystemId, o SubjectId si querés enriquecer el EHR recién creado con información más precisa, por lo que podemos pasar
    // por param un patientId para representar:    new PartySelf(...),    // para representar subject del paciente
    // Metodo para crear un nuevo registro EHRID
    public UUID createNewEhr() {
        try {
            EhrEndpoint ehrEndpoint = openEhrClient.ehrEndpoint();
            UUID ehrId = ehrEndpoint.createEhr();
            logger.info("Created EHR with ID: {}", ehrId);
            return ehrId;
        } catch (WrongStatusCodeException e) {
            //logger.error("Error al crear EHR - Código de estado incorrecto: {}", e.getStatusCode());
            throw new RuntimeException("Error al comunicarse con EHRbase: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error inesperado al crear EHR: {}", e.getMessage());
            throw new RuntimeException("Error al crear EHR: " + e.getMessage(), e);
        }
    }
}
