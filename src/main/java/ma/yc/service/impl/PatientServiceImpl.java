package ma.yc.service.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.Mapper.impl.DossierMapper;
import ma.yc.Mapper.impl.PatientMapper;
import ma.yc.core.Print;
import ma.yc.dao.DossierDao;
import ma.yc.dao.PatientDao;
import ma.yc.dao.impl.DossierDaoImpl;
import ma.yc.dao.impl.PatientDaoImpl;
import ma.yc.dto.DossierDto;
import ma.yc.dto.PatientDto;
import ma.yc.model.Dossier;
import ma.yc.model.Patient;
import ma.yc.service.PatientService;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;
    private Mapper<DossierDto,Dossier> dossierMapper;
    private DossierDao dossierDao;
    private Mapper<PatientDto, Patient> patientMapper;


    public PatientServiceImpl() {
        this.patientDao = new PatientDaoImpl();
        this.patientMapper = new PatientMapper();
        this.dossierDao = new DossierDaoImpl();
        this.dossierMapper = new DossierMapper();
    }

    @Override
    public boolean authentification(PatientDto patientDto) {
        //:verify the patientDto is not null and the matricule is not null
        if (patientDto == null || patientDto.matricule == null) {
            return false;
        }
        //: mapped the patientDto to patientEntity
        Patient patient = this.patientMapper.toEntity(patientDto);
        //: call the patientDaoImpl.authentification(patient)
        //: return the result
        return this.patientDao.authentification(patient);
    }

    @Override
    public List<DossierDto> consulterDossiers(String Matricule) {
        List<Dossier> dossier = this.dossierDao.consulterDossiers(Matricule);
        List<DossierDto> ListdossierDto = new ArrayList<DossierDto>();
        for(Dossier d : dossier){
            ListdossierDto.add(this.dossierMapper.toDto(d));
        }
        return ListdossierDto;
    }

    @Override
    public DossierDto consulterDossierParCode(String CodeDossier) {
        Dossier dossier =  this.dossierDao.consulterDossier(CodeDossier);
        DossierDto dossierDto =  this.dossierMapper.toDto(dossier);
        return  dossierDto;
    }
}
