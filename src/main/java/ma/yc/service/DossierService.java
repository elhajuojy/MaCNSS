package ma.yc.service;

import ma.yc.dto.DossierDto;

import java.util.List;

public interface DossierService {

    boolean enregistrerDossier(DossierDto dossierDto);
    boolean modifierDossier();
    float totalRemoursement();
    List<String> consulterDossier();
    List<DossierDto> consulterDossier(DossierDto dossierDto);
    List<DossierDto> consulterDossiers(DossierDto dossierDto);
    List<String> consulterDossiers();
    boolean suiviEtatDossier(String statusDossier);
    boolean envoyeEmailChangemenetEtat(String statusDossier);
}
