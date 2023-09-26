package ma.yc.service.impl;

import ma.yc.Mapper.impl.DossierMapper;
import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.dao.DossierDao;
import ma.yc.dao.impl.DossierDaoImpl;
import ma.yc.dto.*;
import ma.yc.enums.statusDossier;
import ma.yc.model.Dossier;
import ma.yc.service.DossierService;

import java.util.ArrayList;
import java.util.List;

public class DossierServiceImpl implements DossierService {
    //: dossier
    private DossierMapper dossierMapper ;
    private DossierDao dossierDao;
    public DossierServiceImpl() {
        this.dossierMapper = new DossierMapper();
        this.dossierDao = new DossierDaoImpl();
    }

    @Override
    public boolean enregistrerDossier(DossierDto dossierDto) {
        //: we need to map the dossierDto to the entity
        // : this should be removed in the future
//        DossierDto randomDossierDto = this.randomDossierDto();
        //verify information and checkout some code ;
        Print.log(dossierDto.toString());
        //: implement this mapper method to entity from DossierDto
        Dossier dossier = this.dossierMapper.toEntity(dossierDto);
        //: call the dao to save the dossier
        boolean isSaved = this.dossierDao.enregistrerDossier(dossier);
        if (isSaved){
            this.totalRemoursement(dossierDto.maticule);
        }
        return  isSaved;
    }

    private DossierDto randomDossierDto( ) {
        DossierDto dossierDtoRandom = new DossierDto();
        dossierDtoRandom.numDossier = String.valueOf(Util.generatedLong());
        dossierDtoRandom.patientDto = new PatientDto();
        //patient information
        dossierDtoRandom.patientDto.matricule = "11111";
        dossierDtoRandom.totalRemboursement = 0;
        dossierDtoRandom.status = statusDossier.En_attend;
        //ficher
        dossierDtoRandom.fichier = new FichierDto() ;
        dossierDtoRandom.fichier.dateDepot = "12-12-2023";
        dossierDtoRandom.fichier.totalFraisDossier = 1222;
        dossierDtoRandom.fichier.specialite = "generaliste";
        //ArrayList medicamentsDto
        dossierDtoRandom.medicamentsDto = new ArrayList<>();
        MedicamentDto medicamentDto  = new MedicamentDto();
        medicamentDto.quantite=1;
        medicamentDto.codeBarre=30498474;
        medicamentDto.prix=3837;
        dossierDtoRandom.medicamentsDto.add(medicamentDto);
        MedicamentDto medicamentDto1  = new MedicamentDto();
        medicamentDto1.quantite=2;
        medicamentDto1.codeBarre=384774;
        medicamentDto1.prix=12;
        dossierDtoRandom.medicamentsDto.add(medicamentDto1);
        //Scannerdto
        dossierDtoRandom.scannersDto = new ArrayList<>();
        ScannerDto scannerDto = new ScannerDto();
        scannerDto.scannerId = 23889;
        scannerDto.prix = 23;
        scannerDto.description = "description ";
        ScannerDto scannerDto1 = new ScannerDto();
        scannerDto1.scannerId = 34449;
        scannerDto1.prix = 1294;
        scannerDto1.description = "description 2 ";
        dossierDtoRandom.scannersDto.add(scannerDto);
        dossierDtoRandom.scannersDto.add(scannerDto1);


        return  dossierDtoRandom ;
    }

    @Override
    public boolean modifierDossier() {
        return false;
    }

    @Override
    public float totalRemoursement(String CodeDossier) {
        // : totalRemoubresement

        float TMedicament =  this.dossierDao.CalculateTotalMedicament(CodeDossier);
        float ToalAnalyse =   this.dossierDao.CalculateTotalAnalyse(CodeDossier);
        float TotalVisite = this.dossierDao.CalculateTotalVisiste(CodeDossier);
        float TotalRadio  =   this.dossierDao.CalculateTotalRadio(CodeDossier);
        Print.log(TMedicament);
        Print.log(ToalAnalyse);
        Print.log(TotalVisite);
        Print.log(TotalRadio);

        return TMedicament + ToalAnalyse + TotalVisite + TotalRadio ;
    }

    @Override
    public List<String> consulterDossier() {
        //todo : consulterDossier without checking information of the dossier

        return null;
    }

    @Override
    public List<DossierDto> consulterDossier(DossierDto dossierDto) {
        // : Validation des données
        //validation of codedossier if its String or not empty
        if (dossierDto.numDossier == null || dossierDto.numDossier.isEmpty()){
            //: throw exception
            Dossier dossier = this.dossierDao.consulterDossier("codeDossier");
            DossierDto dossierDto1 = this.dossierMapper.toDto(dossier);
            List<DossierDto> dossierDtos = new ArrayList<>();
            dossierDtos.add(dossierDto1);
            return dossierDtos;
        }

        return null;
    }

    @Override
    public List<DossierDto> consulterDossiers(DossierDto dossierDto) {
        // : Validation des données matricule de patient not null and not empty
        if (dossierDto.patientDto.matricule == null || dossierDto.patientDto.matricule.isEmpty()){
            //: throw exception
            List<Dossier> dossiers = this.dossierDao.consulterDossiers("matricule");
            List<DossierDto> dossierDtos = new ArrayList<>();
            for (Dossier dossier : dossiers) {
                DossierDto dossierDto1 = this.dossierMapper.toDto(dossier);
                dossierDtos.add(dossierDto1);
            }
            return dossierDtos;
        }

        return null;
    }

    @Override
    public List<String> consulterDossiers() {
        //todo : consulterDossiers without checking information of the dossier
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
