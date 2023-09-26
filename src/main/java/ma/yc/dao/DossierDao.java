package ma.yc.dao;

import ma.yc.model.Dossier;

import java.util.List;

public interface DossierDao {

    boolean enregistrerDossier(Dossier dossier);
    boolean modifierDossier();
    float totalRemoursement(String codeDossier);
    Dossier consulterDossier(String CodeDossier);
    List<Dossier> consulterDossiers(String MatriculeUser);
    boolean suiviEtatDossier(Dossier dossier);
    boolean envoyeEmailChangemenetEtat(String statusDossier);
    String SpecialiteFetch(String codeDossier);
    Float CalculateTotalMedicament(String codeDossier);
    Float CalculateTotalAnalyse(String codeDossier);
    Float CalculateTotalVisiste(String codeDossier);
    Float CalculateTotalRadio(String codeDossier);


}
