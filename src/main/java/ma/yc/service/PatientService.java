package ma.yc.service;

import ma.yc.dto.DossierDto;
import ma.yc.dto.PatientDto;

import java.util.List;

public interface PatientService {
        //+ authentification(): boolean
        //+ consulterDossier(): List
        //+ consulterDossierMatricule(): List

        boolean authentification(PatientDto patientDto);
        List<DossierDto> consulterDossiers(String Matricule);
       DossierDto consulterDossierParCode(String CodeDossier);
}
