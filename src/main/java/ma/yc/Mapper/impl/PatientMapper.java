package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.DossierDto;
import ma.yc.dto.PatientDto;
import ma.yc.model.Patient;

import java.sql.PreparedStatement;

public class PatientMapper implements Mapper<PatientDto , Patient> {
    @Override
    public Patient toEntity() {
        return null;
    }

    @Override
    public Patient toEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setMatricule(patientDto.matricule);
        patient.setNom(patientDto.nom);
//        patient.setDossiers(patientDto.dossiers);
        return patient;
    }

    @Override
    public PatientDto toDto() {
        return null;

    }

    @Override
    public PatientDto toDto(Patient t) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Patient patient, PreparedStatement preparedStatement) {
        return null;
    }
}
