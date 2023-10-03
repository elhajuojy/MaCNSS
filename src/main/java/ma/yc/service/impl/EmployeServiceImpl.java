package ma.yc.service.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.Mapper.impl.EmployeeMapper;
import ma.yc.core.Util;
import ma.yc.dao.EmployeDao;
import ma.yc.dao.impl.EmployeDaoImpl;
import ma.yc.dto.EmployeDto;
import ma.yc.enums.Statusretaitre;
import ma.yc.model.Employe;
import ma.yc.service.EmployeeService;

import java.util.Date;

public class EmployeServiceImpl implements EmployeeService {

    private EmployeDao employeDao ;
    private Mapper<EmployeDto,Employe> employeeMapper ;

    public EmployeServiceImpl() {
        this.employeDao = new EmployeDaoImpl();
        this.employeeMapper = new EmployeeMapper();
    }

    @Override
    public EmployeDto addEmployee(EmployeDto employeeDto) {
        //: DO SOME VALIDATION ON THE DATA
        if (employeeDto.nom.isEmpty() || !Util.verifyEmail(employeeDto.email) ||
                employeeDto.prenom.isEmpty()||
                employeeDto.societe.id.describeConstable().isEmpty())
        {
            return null;
        }

        // : GENERATE THE MATRICULE
        employeeDto.matricule = Util.generatedLong();
        if (this.isEmployeeExist(employeeDto.matricule)){
            return null;
        }
        // : CALL THE MAPPER SO WE CAN MAP THE DTO TO ENTITY
        Employe employe = this.employeeMapper.toEntity(employeeDto);
        // : CALL THE DAO SO WE CAN SAVE THE ENTITY
        if (this.employeDao.addEmployee(employe)){
            return employeeDto;
        }

        return null;
    }


    @Override
    public EmployeDto consultEmployee(long employeeMatricule) {
        Employe employe = this.employeDao.consulterCompte(String.valueOf(employeeMatricule));
        return this.employeeMapper.toDto(employe);
    }

    private EmployeDto dumpEmployee() {
        EmployeDto employeDto = new EmployeDto();
        employeDto.matricule = 1L;
        employeDto.nom = "nom";
        employeDto.prenom = "prenom";
        employeDto.email = "email";
        employeDto.dateNaissance = new Date().toString();
        employeDto.tel = "tel";
        employeDto.retaitre = Statusretaitre.OUI;
        employeDto.jourTravaillesParMois = null;
        employeDto.salaires = null;
        employeDto.salaire = 1244.22;
        return employeDto;
    }

    @Override
    public boolean isEmployeeExist(Long id) {
        Employe employe = this.employeDao.consulterCompte(id.toString());
        if (employe != null){
            return  true;
        }
        return false;
    }

    @Override
    public boolean updateEmployeeSalary(Long id,Long idSociete, double salary) {
        //TODO : SOME VALIDATION CHECK FIRST IF THE
        if (!this.isEmployeeExist(id)){
            return false ;
        }
        return this.employeDao.updateEmployeeSalary(salary, idSociete, id);
    }

    @Override
    public boolean declareJourTravileParEmployee(long societeId, long employeeMatricule, int jourTravile) {
        return this.employeDao.declareJourTravileParEmployee(societeId, employeeMatricule, jourTravile);

    }

    @Override
    public boolean login(String[] credentials) {
        if (true){
            return  true;
        }
        return false;
    }

    @Override
    public boolean logout() {
        if (true){
            return  true;
        }
        return false;
    }
}

