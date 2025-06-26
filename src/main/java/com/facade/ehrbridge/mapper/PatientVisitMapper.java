package com.facade.ehrbridge.mapper;

import com.facade.ehrbridge.model.PatientVisitRequestDTO;
import com.facade.ehrbridge.model.ProblemDiagnosisEvaluationDTO;
import com.facade.ehrbridge.model.MedicationOrderDTO;
import com.facade.ehrbridge.patientvisitcomposition.PatientVisitComposition;
import com.facade.ehrbridge.patientvisitcomposition.definition.ProblemDiagnosisCauseElement;
import com.facade.ehrbridge.patientvisitcomposition.definition.ProblemDiagnosisEvaluation;
import com.facade.ehrbridge.patientvisitcomposition.definition.MedicationOrderInstruction;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.nedap.archie.rm.datavalues.DvText;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientVisitMapper {

    PatientVisitMapper INSTANCE = Mappers.getMapper(PatientVisitMapper.class);

    @Mapping(source = "visitDate", target = "startTimeValue")
    @Mapping(source = "location", target = "location")
    @Mapping(source = "problemDiagnosisEvaluation", target = "problemDiagnosis")
    @Mapping(source = "medicationOrder", target = "medicationOrder")
    PatientVisitComposition toComposition(PatientVisitRequestDTO dto);

    ProblemDiagnosisEvaluation toProblemDiagnosisEvaluation(ProblemDiagnosisEvaluationDTO dto);

    MedicationOrderInstruction toMedicationOrder(MedicationOrderDTO dto);

    default DvCodedText map(String value) {
        return new DvCodedText(value, (CodePhrase) null);
    }

    default List<ProblemDiagnosisCauseElement> mapCause(List<String> causes) {
        if (causes == null) return null;
        return causes.stream()
                .map(c -> {
                    ProblemDiagnosisCauseElement e = new ProblemDiagnosisCauseElement();
                    e.setValue(new DvCodedText(c, (CodePhrase) null));
                    return e;
                })
                .toList();
    }

    default List<Cluster> mapClusterList(List<String> input) {
        if (input == null) return null;
        return input.stream()
                .map(s -> {
                    Cluster c = new Cluster();
                    c.setItems(List.of()); // opcional: puedes llenar los items si los necesitas
                    c.setName(new DvText(s)); // 🔧 aquí va el cambio
                    return c;
                })
                .toList();
    }

}
