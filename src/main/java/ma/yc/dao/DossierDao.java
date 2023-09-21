package ma.yc.dao;

import java.util.List;

public interface DossierDao {

    boolean enregistrerDossier();
    boolean modifierDossier();
    float totalRemoursement();
    List<String> consulterDossier();
    List<String> consulterDossiers();
    List<String> consulterDossierMatricule();
    boolean suiviEtatDossier(String statusDossier);
    boolean envoyeEmailChangemenetEtat(String statusDossier);



}
