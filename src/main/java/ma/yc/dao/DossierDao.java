package ma.yc.dao;

import ma.yc.model.Dossier;

import java.util.List;

public interface DossierDao {

    boolean enregistrerDossier(Dossier dossier);
    boolean modifierDossier();
    float totalRemoursement();
    List<String> consulterDossier();
    List<String> consulterDossiers();
    boolean suiviEtatDossier(String statusDossier);
    boolean envoyeEmailChangemenetEtat(String statusDossier);



}
