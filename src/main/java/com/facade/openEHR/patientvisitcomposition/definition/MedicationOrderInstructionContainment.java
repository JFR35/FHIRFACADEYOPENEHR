package com.facade.openEHR.patientvisitcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.openehr.sdk.generator.commons.aql.containment.Containment;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.AqlFieldImp;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.ListAqlFieldImp;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.ListSelectAqlField;
import org.ehrbase.openehr.sdk.generator.commons.aql.field.SelectAqlField;
import org.ehrbase.openehr.sdk.generator.commons.shareddefinition.Language;

public class MedicationOrderInstructionContainment extends Containment {
  public SelectAqlField<MedicationOrderInstruction> MEDICATION_ORDER_INSTRUCTION = new AqlFieldImp<MedicationOrderInstruction>(MedicationOrderInstruction.class, "", "MedicationOrderInstruction", MedicationOrderInstruction.class, this);

  public ListSelectAqlField<MedicationOrderOrderActivity> ORDER = new ListAqlFieldImp<MedicationOrderOrderActivity>(MedicationOrderInstruction.class, "/activities[at0001]", "order", MedicationOrderOrderActivity.class, this);

  public ListSelectAqlField<Cluster> EXTENSION = new ListAqlFieldImp<Cluster>(MedicationOrderInstruction.class, "/protocol[at0005]/items[at0008]", "extension", Cluster.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(MedicationOrderInstruction.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<String> NARRATIVE_VALUE = new AqlFieldImp<String>(MedicationOrderInstruction.class, "/narrative|value", "narrativeValue", String.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(MedicationOrderInstruction.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(MedicationOrderInstruction.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public SelectAqlField<TemporalAccessor> EXPIRY_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(MedicationOrderInstruction.class, "/expiry_time|value", "expiryTimeValue", TemporalAccessor.class, this);

  private MedicationOrderInstructionContainment() {
    super("openEHR-EHR-INSTRUCTION.medication_order.v3");
  }

  public static MedicationOrderInstructionContainment getInstance() {
    return new MedicationOrderInstructionContainment();
  }
}
