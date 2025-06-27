package com.facade.ehrbridge.service;

import java.util.UUID;

/**
 * Caso de uso para crear un neuvo EHR en el servidor EHRbase
 */
public interface CreateEhrIdUseCase {

    /**
     * Crea un nuevo EHR y devuelve su identificador único.
     *
     * @return el UUID del nuevo EHR creado.
     */
    //String createNewEhr();

    public UUID createNewEhr();
}
