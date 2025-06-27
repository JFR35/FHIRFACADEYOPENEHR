package com.facade.ehrbridge.service;

import com.facade.ehrbridge.model.PatientVisitRequestDTO;

public interface CreatePatientVisitCompositionUseCase {
    String createPatientVisitComposition(PatientVisitRequestDTO requestDTO);
}
