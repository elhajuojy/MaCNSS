package ma.yc.service.impl;

import ma.yc.Mapper.impl.DossierMapper;
import ma.yc.dao.DossierDao;
import ma.yc.dao.impl.DossierDaoImpl;
import ma.yc.dto.DossierDto;
import ma.yc.model.Dossier;
import ma.yc.service.DossierService;

import java.util.List;

public class DossierServiceImpl implements DossierService {
    //todo: dossier
    private DossierMapper dossierMapper ;
    private DossierDao dossierDao;
    public DossierServiceImpl() {
        this.dossierMapper = new DossierMapper();
        this.dossierDao = new DossierDaoImpl();
    }

    @Override
    public boolean enregistrerDossier(DossierDto dossierDto) {
        Dossier dossier1 = this.dossierMapper.toEntity(dossierDto);
        this.dossierDao.enregistrerDossier();
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
