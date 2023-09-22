package ma.yc.service;

import ma.yc.dto.DossierDto;

import java.util.List;

public interface PatientService {

        //+ consulterDossier(): List
        //+ consulterDossierMatricule(): List
        List<String> consulterDossiers(DossierDto dossierDto);
        List<String> consulterDossierParCode(DossierDto dossierDto);
}
