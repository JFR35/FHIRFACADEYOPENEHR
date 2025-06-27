package com.facade.ehrbridge.patientvisitcomposition;

import com.facade.ehrbridge.patientvisitcomposition.definition.MedicationOrderInstruction;
import com.facade.ehrbridge.patientvisitcomposition.definition.ProblemDiagnosisEvaluation;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.openehr.sdk.generator.commons.aql.containment.Containment;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.AqlFieldImp;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.ListAqlFieldImp;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.ListSelectAqlField;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.SelectAqlField;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Category;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Language;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.NullFlavour;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Setting;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Territory;

public class PatientVisitCompositionContainment extends Containment {
  public SelectAqlField<PatientVisitComposition> PATIENT_VISIT_COMPOSITION = new AqlFieldImp<PatientVisitComposition>(PatientVisitComposition.class, "", "PatientVisitComposition", PatientVisitComposition.class, this);

  public SelectAqlField<Category> CATEGORY_DEFINING_CODE = new AqlFieldImp<Category>(PatientVisitComposition.class, "/category|defining_code", "categoryDefiningCode", Category.class, this);

  public SelectAqlField<String> REPORT_ID_VALUE = new AqlFieldImp<String>(PatientVisitComposition.class, "/context/other_context[at0001]/items[at0002]/value|value", "reportIdValue", String.class, this);

  public SelectAqlField<NullFlavour> REPORT_ID_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(PatientVisitComposition.class, "/context/other_context[at0001]/items[at0002]/null_flavour|defining_code", "reportIdNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<String> STATUS_VALUE = new AqlFieldImp<String>(PatientVisitComposition.class, "/context/other_context[at0001]/items[at0005]/value|value", "statusValue", String.class, this);

  public SelectAqlField<NullFlavour> STATUS_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(PatientVisitComposition.class, "/context/other_context[at0001]/items[at0005]/null_flavour|defining_code", "statusNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<Cluster> EXTENSION = new ListAqlFieldImp<Cluster>(PatientVisitComposition.class, "/context/other_context[at0001]/items[at0006]", "extension", Cluster.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(PatientVisitComposition.class, "/context/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(PatientVisitComposition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(PatientVisitComposition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(PatientVisitComposition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(PatientVisitComposition.class, "/context/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public SelectAqlField<Setting> SETTING_DEFINING_CODE = new AqlFieldImp<Setting>(PatientVisitComposition.class, "/context/setting|defining_code", "settingDefiningCode", Setting.class, this);

  public SelectAqlField<ProblemDiagnosisEvaluation> PROBLEM_DIAGNOSIS = new AqlFieldImp<ProblemDiagnosisEvaluation>(PatientVisitComposition.class, "/content[openEHR-EHR-EVALUATION.problem_diagnosis.v1]", "problemDiagnosis", ProblemDiagnosisEvaluation.class, this);

  public SelectAqlField<MedicationOrderInstruction> MEDICATION_ORDER = new AqlFieldImp<MedicationOrderInstruction>(PatientVisitComposition.class, "/content[openEHR-EHR-INSTRUCTION.medication_order.v3]", "medicationOrder", MedicationOrderInstruction.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(PatientVisitComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(PatientVisitComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(PatientVisitComposition.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(PatientVisitComposition.class, "/territory", "territory", Territory.class, this);

  private PatientVisitCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.report.v1");
  }

  public static PatientVisitCompositionContainment getInstance() {
    return new PatientVisitCompositionContainment();
  }
}
