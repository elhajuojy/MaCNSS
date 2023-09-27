package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.*;
import ma.yc.model.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DossierMapper implements Mapper<DossierDto, Dossier> {

    private final Mapper<VisiteDto, Visite> visiteMapper  ;
    private final Mapper<RadioDto, Radio> radioMapper ;
    private final Mapper<AnalyseDto,Analyse> analyseMapper ;
    private final Mapper<MedicamentDto, Medicament> medicamentMapper ;
    private final Mapper<ScannerDto, Scanner> scannerMapper ;
    private final Mapper<FichierDto, Fichier> fichierMapper ;
    private final Mapper<PatientDto, Patient> patientMapper ;


    public DossierMapper() {
        this.visiteMapper = new VisteMapper();
        this.radioMapper = new RadioMapper();
        this.analyseMapper = new AnalyseMapper();
        this.medicamentMapper = new MedicamentMapper();
        this.scannerMapper = new ScannerMapper();
        this.fichierMapper = new FichierMapper();
        this.patientMapper = new PatientMapper();

    }

    @Override
    public Dossier toEntity() {
        //todo: implement this method to entity from DossierDto
        return null;
    }

    @Override
    public Dossier toEntity(DossierDto dossierDto) {

        //: implement this method to entity from DossierDto
        Dossier dossier = new Dossier();
        dossier.setNumDossier(dossierDto.numDossier);
        dossier.setStatus(dossierDto.status);
        dossier.setTotalRemboursement(dossierDto.totalRemboursement);

        //:implement those mapper methods to entity
        List<Visite> visites = new ArrayList<>();
        if (dossierDto.visitesDto != null) {
            for (VisiteDto visiteDto : dossierDto.visitesDto) {
                Visite visite = this.visiteMapper.toEntity(visiteDto);
                visites.add(visite);
            }
        }
        dossier.setVisites(visites);

        List<Radio> radios = new ArrayList<>();
        if (dossierDto.radiosDto != null) {
            for (RadioDto radioDto : dossierDto.radiosDto) {
                Radio radio = this.radioMapper.toEntity(radioDto);
                radios.add(radio);
            }
        }
        dossier.setRadios(radios);

        List<Analyse> analyses = new ArrayList<>();
        if (dossierDto.analysesDto != null) {
            for (AnalyseDto analyseDto : dossierDto.analysesDto) {
                Analyse analyse = this.analyseMapper.toEntity(analyseDto);
                analyses.add(analyse);
            }
        }
        dossier.setAnalyses(analyses);

        List<Medicament> medicaments = new ArrayList<>();
        if (dossierDto.medicamentsDto != null) {
            for (MedicamentDto medicamentDto : dossierDto.medicamentsDto) {
                Medicament medicament = this.medicamentMapper.toEntity(medicamentDto);
                medicaments.add(medicament);
            }
        }
        dossier.setMedicaments(medicaments);

        List<Scanner> scanners = new ArrayList<>();
        if (dossierDto.scannersDto != null) {
            for (ScannerDto scannerDto : dossierDto.scannersDto) {
                Scanner scanner = this.scannerMapper.toEntity(scannerDto);
                scanners.add(scanner);
            }
        }
        dossier.setScanners(scanners);

        if (dossierDto.fichier != null) {
            Fichier fichier = this.fichierMapper.toEntity(dossierDto.fichier);
            dossier.setFichier(fichier);
        }

        if (dossierDto.patientDto != null) {
            Patient patient = this.patientMapper.toEntity(dossierDto.patientDto);
            dossier.setPatient(patient);
        }



        return dossier;
    }

    @Override
    public DossierDto toDto() {
        //todo: implement this method to dossierDto from DossierEntity
        return null;
    }

    @Override
    public DossierDto toDto(Dossier d) {
        DossierDto dossierDto = new DossierDto();
        dossierDto.numDossier = d.getNumDossier();
        dossierDto.status = d.getStatus();
        dossierDto.totalRemboursement = d.getTotalRemboursement();
        return dossierDto;
    }

    @Override
    public PreparedStatement toPreparedStatement(Dossier dossier, PreparedStatement preparedStatement) {
        return null;
    }
}
