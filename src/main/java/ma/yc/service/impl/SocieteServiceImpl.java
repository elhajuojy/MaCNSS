package ma.yc.service.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.Mapper.impl.SocieteMapper;
import ma.yc.core.Util;
import ma.yc.dao.SocieteDao;
import ma.yc.dao.UserDao;
import ma.yc.dao.impl.SocieteDaoImpl;
import ma.yc.dto.EmployeDto;
import ma.yc.dto.SocieteDto;
import ma.yc.model.Hourly_emp;
import ma.yc.model.Utilisateur;
import ma.yc.service.EmployeeService;
import ma.yc.service.SocieteService;

import java.util.ArrayList;

public class SocieteServiceImpl implements SocieteService {
    private EmployeeService employeeService ;
    private SocieteMapper societeMapper ;
    private SocieteDao societeDao ;
    private UserDao userDao ;

    public SocieteServiceImpl() {
        SocieteDaoImpl societeDao = new SocieteDaoImpl();
        this.employeeService = new EmployeServiceImpl();
        this.societeDao = societeDao ;
        this.societeMapper = new SocieteMapper();
        this.userDao = societeDao;
    }

    @Override
    public boolean login(String[] credentials) {
        //: FIRST EXTRACT DATA EMAIL AND ID FROM THE CREDENTIALS EMAIL 0 AND ID 1
        String email = credentials[0];
        String id = credentials[1];
        // : DO SOME VALIDATION ON THE DATA
        if(!Util.verifyEmail(email)|| email.isBlank() || id.isBlank() || id.isEmpty() ){
            return false;
        }

        //TODO : CALL THE MAPPER SO WE CAN MAP THE DTO TO ENTITY

        SocieteDto societeDto = new SocieteDto();
        societeDto.id = Long.valueOf(id);
        societeDto.email = email ;

        Utilisateur utilisateur = this.societeMapper.toEntity(societeDto);
        utilisateur.toString();


        return this.userDao.login(utilisateur);

    }

    @Override
    public boolean logout() {
        if (true){
            return true;
        }
        return false;
    }

    @Override
    public SocieteDto addSociete(SocieteDto societeDto) {
            
        return this.dumpSociete();
    }

    private SocieteDto dumpSociete() {
        SocieteDto societeDto = new SocieteDto();
        societeDto.email =  "company@exmaple.com";
        societeDto.nom = "company";
        societeDto.id = 123456789L;
        societeDto.tel = "0612345678";
        societeDto.adresse = "company address";
        return societeDto;
    }

    @Override
    public SocieteDto consultSociete(long societeId) {
        return this.dumpSociete();
    }

    @Override
    public EmployeDto addEmployee(long societeId, EmployeDto employeeDto) {
        //TODO : IN THIS FACE THE EMPLOYE MUST BE ADD AS A EMPLOYE OF THE SOCIETE BY ADDING THE SOCIETE ID TO THE EMPLOYE
        employeeDto.societe = this.dumpSociete();
        return this.employeeService.addEmployee(employeeDto);
    }

    @Override
    public EmployeDto consultEmployee(long societeId, long employeeMatricule) {
        return this.employeeService.consultEmployee(employeeMatricule);
    }

    @Override
    public EmployeDto declareJourTravileParEmployee(long societeId, long employeeMatricule, int jourTravile) {
        //TODO : IN THIS FACE THE EMPLOYE MUST BE ADD AS A EMPLOYE OF THE SOCIETE BY ADDING THE SOCIETE ID TO THE EMPLOYE
        EmployeDto employeDto = this.employeeService.consultEmployee(employeeMatricule);
        //
        Hourly_emp hourly_emp = new Hourly_emp();
        hourly_emp.setJourTravaille(jourTravile)  ;
        hourly_emp.setId(employeDto.matricule);
        employeDto.jourTravaillesParMois.add(hourly_emp);
        return employeDto;
    }
}
