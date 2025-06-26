package com.facade.ehrbridge.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public class ProblemDiagnosisEvaluationDTO {

    @NotBlank
    private String problemDiagnosisName; // De DvCodedText
    @NotBlank
    private List<String> cause; // De ProblemDiagnosisCauseElement
    private LocalDateTime dateTimeOfOnset; // De TemporalAcccesor
    private List<String> status; // Simplificado de Cluster

    public String getProblemDiagnosisName() {
        return problemDiagnosisName;
    }

    public void setProblemDiagnosisName(String problemDiagnosisName) {
        this.problemDiagnosisName = problemDiagnosisName;
    }

    public List<String> getCause() {
        return cause;
    }

    public void setCause(List<String> cause) {
        this.cause = cause;
    }

    public LocalDateTime getDateTimeOfOnset() {
        return dateTimeOfOnset;
    }

    public void setDateTimeOfOnset(LocalDateTime dateTimeOfOnset) {
        this.dateTimeOfOnset = dateTimeOfOnset;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }
}
