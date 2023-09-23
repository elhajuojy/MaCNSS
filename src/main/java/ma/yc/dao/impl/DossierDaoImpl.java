package ma.yc.dao.impl;

import ma.yc.dao.DossierDao;

import java.util.List;

public class DossierDaoImpl implements DossierDao {

    //Dossier uses the DossierEntity class which means
    // all subclass which inside the DossierEntity class
    //todo : the DossierDaoImpl uses the DossierEntity class
    @Override
    public boolean enregistrerDossier() {
        return false;
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
        return false;
    }

    @Override
    public boolean envoyeEmailChangemenetEtat(String statusDossier) {
        return false;
    }
}
