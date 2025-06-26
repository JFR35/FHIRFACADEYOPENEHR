package com.facade.ehrbridge.model;

import java.time.LocalDateTime;
import java.util.List;

public class ProblemDiagnosisEvaluationDTO {

    private String problemDiagnosisName; // De DvCodedText
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
