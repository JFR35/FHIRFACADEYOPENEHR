package com.facade.openEHR.patientvisitcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.openehr.sdk.generator.commons.annotations.Archetype;
import org.ehrbase.openehr.sdk.generator.commons.annotations.Entity;
import org.ehrbase.openehr.sdk.generator.commons.annotations.Path;
import org.ehrbase.openehr.sdk.generator.commons.interfaces.EntryEntity;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Language;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.NullFlavour;

@Entity
@Archetype("openEHR-EHR-EVALUATION.problem_diagnosis.v1")
@Generated(
    value = "org.ehrbase.openehr.sdk.generator.ClassGenerator",
    date = "2025-06-24T17:43:34.489693500+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 2.23.0-SNAPSHOT"
)
public class ProblemDiagnosisEvaluation implements EntryEntity {
  /**
   * Path: Patient_Visit/Problem/Diagnosis/Problem/Diagnosis name
   * Description: Identification of the problem or diagnosis, by name.
   * Comment: Coding of the name of the problem or diagnosis with a terminology is preferred, where possible.
   */
  @Path("/data[at0001]/items[at0002]/value")
  private DvCodedText problemDiagnosisName;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/structure/Problem/Diagnosis name/null_flavour
   */
  @Path("/data[at0001]/items[at0002]/null_flavour|defining_code")
  private NullFlavour problemDiagnosisNameNullFlavourDefiningCode;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/Structured body site
   * Description: A structured anatomical location for the problem or diagnosis.
   * Comment: Use this SLOT to insert the CLUSTER.anatomical_location or CLUSTER.relative_location archetypes if the requirements for recording the anatomical location are determined at run-time by the application or require more complex modelling such as relative locations.
   *
   * If the anatomical location is included in the Problem/diagnosis name via precoordinated codes, use of this SLOT becomes redundant.
   */
  @Path("/data[at0001]/items[at0039]")
  private List<Cluster> structuredBodySite;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/Cause
   * Description: A cause, set of causes, or manner of causation of the problem or diagnosis.
   * Comment: Also known as 'aetiology' or 'etiology'. Coding with an external terminology is preferred, where possible.
   */
  @Path("/data[at0001]/items[at0078]")
  private List<ProblemDiagnosisCauseElement> cause;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/Date/time of onset
   * Description: Estimated or actual date/time that signs or symptoms of the problem/diagnosis were first observed.
   * Comment: Data captured/imported as "Age at onset" should be converted to a date using the subject's date of birth.
   */
  @Path("/data[at0001]/items[at0077]/value|value")
  private TemporalAccessor dateTimeOfOnsetValue;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/structure/Date/time of onset/null_flavour
   */
  @Path("/data[at0001]/items[at0077]/null_flavour|defining_code")
  private NullFlavour dateTimeOfOnsetNullFlavourDefiningCode;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/Specific details
   * Description: Details that are additionally required to record as unique attributes of this problem or diagnosis.
   * Comment: May include structured detail about the grading or staging of the diagnosis; diagnostic criteria, classification criteria or formal severity assessments such as Common Terminology Criteria for Adverse Events.
   */
  @Path("/data[at0001]/items[at0043]")
  private List<Cluster> specificDetails;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/Status
   * Description: Structured details for location-, domain-, episode- or workflow-specific aspects of the diagnostic process.
   * Comment: Use status or context qualifiers with care, as they are variably used in practice and interoperability cannot be assured unless usage is clearly defined with the community of use. For example: active status - active, inactive, resolved, in remission; evolution status - initial, interim/working, final; temporal status - current, past; episodicity status - first, new, ongoing; admission status - admission, discharge; or priority status - primary, secondary.
   */
  @Path("/data[at0001]/items[at0046]")
  private List<Cluster> status;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/Extension
   * Description: Additional information required to capture local content or to align with other reference models/formalisms.
   * Comment: For example: local information requirements or additional metadata to align with FHIR or CIMI equivalents.
   */
  @Path("/protocol[at0032]/items[at0071]")
  private List<Cluster> extension;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/subject
   */
  @Path("/subject")
  private PartyProxy subject;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/language
   */
  @Path("/language")
  private Language language;

  /**
   * Path: Patient_Visit/Problem/Diagnosis/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setProblemDiagnosisName(DvCodedText problemDiagnosisName) {
     this.problemDiagnosisName = problemDiagnosisName;
  }

  public DvCodedText getProblemDiagnosisName() {
     return this.problemDiagnosisName ;
  }

  public void setProblemDiagnosisNameNullFlavourDefiningCode(
      NullFlavour problemDiagnosisNameNullFlavourDefiningCode) {
     this.problemDiagnosisNameNullFlavourDefiningCode = problemDiagnosisNameNullFlavourDefiningCode;
  }

  public NullFlavour getProblemDiagnosisNameNullFlavourDefiningCode() {
     return this.problemDiagnosisNameNullFlavourDefiningCode ;
  }

  public void setStructuredBodySite(List<Cluster> structuredBodySite) {
     this.structuredBodySite = structuredBodySite;
  }

  public List<Cluster> getStructuredBodySite() {
     return this.structuredBodySite ;
  }

  public void setCause(List<ProblemDiagnosisCauseElement> cause) {
     this.cause = cause;
  }

  public List<ProblemDiagnosisCauseElement> getCause() {
     return this.cause ;
  }

  public void setDateTimeOfOnsetValue(TemporalAccessor dateTimeOfOnsetValue) {
     this.dateTimeOfOnsetValue = dateTimeOfOnsetValue;
  }

  public TemporalAccessor getDateTimeOfOnsetValue() {
     return this.dateTimeOfOnsetValue ;
  }

  public void setDateTimeOfOnsetNullFlavourDefiningCode(
      NullFlavour dateTimeOfOnsetNullFlavourDefiningCode) {
     this.dateTimeOfOnsetNullFlavourDefiningCode = dateTimeOfOnsetNullFlavourDefiningCode;
  }

  public NullFlavour getDateTimeOfOnsetNullFlavourDefiningCode() {
     return this.dateTimeOfOnsetNullFlavourDefiningCode ;
  }

  public void setSpecificDetails(List<Cluster> specificDetails) {
     this.specificDetails = specificDetails;
  }

  public List<Cluster> getSpecificDetails() {
     return this.specificDetails ;
  }

  public void setStatus(List<Cluster> status) {
     this.status = status;
  }

  public List<Cluster> getStatus() {
     return this.status ;
  }

  public void setExtension(List<Cluster> extension) {
     this.extension = extension;
  }

  public List<Cluster> getExtension() {
     return this.extension ;
  }

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
