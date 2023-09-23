package ma.yc.service.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.Mapper.impl.PatientMapper;
import ma.yc.dao.PatientDao;
import ma.yc.dao.impl.PatientDaoImpl;
import ma.yc.dto.DossierDto;
import ma.yc.dto.PatientDto;
import ma.yc.model.Patient;
import ma.yc.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;
    private Mapper<PatientDto, Patient> patientMapper;


    public PatientServiceImpl() {
        this.patientDao = new PatientDaoImpl();
        this.patientMapper = new PatientMapper();
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
    public List<String> consulterDossiers(DossierDto dossierDto) {
        return null;
    }

    @Override
    public List<String> consulterDossierParCode(DossierDto dossierDto) {
        return null;
    }
}
