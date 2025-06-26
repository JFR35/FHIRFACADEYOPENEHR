package com.facade.ehrbridge.model;

import java.time.LocalDateTime;

/**
 * Basado en PatientVisitComposition
 */
public class PatientVisitRequestDTO {

    // Metadata
    private String visitId;
    private LocalDateTime visitDate;
    private String location;

    private ProblemDiagnosisEvaluationDTO problemDiagnosisEvaluation;
    private MedicationOrderDTO medicationOrder;


    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ProblemDiagnosisEvaluationDTO getProblemDiagnosisEvaluation() {
        return problemDiagnosisEvaluation;
    }

    public void setProblemDiagnosisEvaluation(ProblemDiagnosisEvaluationDTO problemDiagnosisEvaluation) {
        this.problemDiagnosisEvaluation = problemDiagnosisEvaluation;
    }

    public MedicationOrderDTO getMedicationOrder() {
        return medicationOrder;
    }

    public void setMedicationOrder(MedicationOrderDTO medicationOrder) {
        this.medicationOrder = medicationOrder;
    }
}
