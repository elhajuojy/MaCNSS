package ma.yc.service.impl;

import ma.yc.dto.DossierDto;
import ma.yc.service.DossierService;

import java.util.List;

public class DossierServiceImpl implements DossierService {

    public DossierServiceImpl() {
    }

    @Override
    public boolean enregistrerDossier(DossierDto dossierDto) {
        return  false;
    }

    @Override
    public boolean modifierDossier() {
        return false;
    }

    @Override
    public float totalRemoursement() {
        return 0;
    }

    @Override
    public List<String> consulterDossier() {
        return null;
    }

    @Override
    public List<String> consulterDossiers() {
        return null;
    }

    @Override
    public boolean suiviEtatDossier(String statusDossier) {

        this.envoyeEmailChangemenetEtat("message");
        return false;
    }

    @Override
    public boolean envoyeEmailChangemenetEtat(String statusDossier) {
        //todo:we need email to sent the changement etat
        return false;
    }
}
