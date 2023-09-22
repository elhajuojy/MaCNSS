package ma.yc.service;

import java.util.List;

public interface PatientService {

        //+ consulterDossier(): List
        //+ consulterDossierMatricule(): List
        List<String> consulterDossiers();
        List<String> consulterDossierMatricule(String matricule);
}
