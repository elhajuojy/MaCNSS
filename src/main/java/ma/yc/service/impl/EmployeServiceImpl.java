package ma.yc.service.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.Mapper.impl.EmployeeMapper;
import ma.yc.core.Print;
import ma.yc.core.Util;
import ma.yc.dao.EmployeDao;
import ma.yc.dao.impl.EmployeDaoImpl;
import ma.yc.dto.EmployeDto;
import ma.yc.enums.Statusretaitre;
import ma.yc.model.Employe;
import ma.yc.model.SalaryHistory;
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
        //map data
        EmployeDto employeDto = this.employeeMapper.toDto(employe);
        if (employeDto!= null){
            //TODO : IF THE USER UNDER AGE OF 55 HE CANNOT BENEFITS FROM THE RETIREMENT
            String date = employeDto.dateNaissance;
            String[] dateArray = date.split("-");
            int year = Integer.parseInt(dateArray[0]);
            int month = Integer.parseInt(dateArray[1]);
            int day = Integer.parseInt(dateArray[2]);
            int age = Util.calculateAge(year, month, day);
            if (age >= 55){
                employeDto.retaitre = Statusretaitre.OUI;
                double retirementSalary = this.calulateRetiredSalary(employeDto);
                employeDto.salaireRetraite = retirementSalary;
                return employeDto;
            }else {
                employeDto.retaitre = Statusretaitre.NON;
                return employeDto;
            }
        }


        return null;
    }

    private double countAddtionalSalary(EmployeDto employeDto) {
        return 0;
    }

    private double calulateRetiredSalary(EmployeDto employeDto) {
        //TODO : FIRST NEED TO LOOP INTO LASTS 96 RECORD IN THE LIST OF SALARY HISTORY
        double salarySum = 0.0;
        double avergeSalary = 0.0;
        double retirementSalary = 0.0;
        if (employeDto.salaires != null || employeDto.nombreJourTravaille >= 1320) {
            //TODO : GET THE LAST 96 RECORDS
                for (int i = 0; i < employeDto.salaires.size(); i++) {
                    //TODO : CALCULATE THE AVERAGE OF THE SALARY
                    salarySum += employeDto.salaires.get(i).getSalaire();
                    //TODO : CALCULATE THE AVERAGE OF THE SALARY
                }
                //TODO : CALCULATE THE AVERAGE OF THE SALARY
                avergeSalary = salarySum / 96 ;
                


                //TODO averageSalary = averageSalary /2 ; // 50% of the salary
            //TODO : CALCULATE ALL DAYS OF WORK AFTER 1320 DAYS
            int totalworkDays = employeDto.nombreJourTravaille;
            totalworkDays = totalworkDays - 3240;
            Integer precentagesSalary =  totalworkDays / 216;

            precentagesSalary = precentagesSalary + 50;


            if (precentagesSalary > 70){
                precentagesSalary = 70;
            }
            retirementSalary = avergeSalary * precentagesSalary / 100;
            Print.log(retirementSalary);



            //TODO : THIS IS NOT COMPLETE YET IF THE SALARY IS MORE THAN 6000 DH THE BASED SALARY WILL BE 6000 DH
            if (retirementSalary > 6000){
                retirementSalary = 6000;
            }
            //TODO : IF THE SALARY IS LESS THAN 1000 DH THE BASED SALARY WILL BE 1000 DH
            if (retirementSalary < 1000){
                retirementSalary = 1000;
            }




//            //TODO : IF THE EMPLOYE WORKED IN HIS CREER MORE THAN BASED 1360 DAY HE WILL GET 1% FROM EACH 216 DAY HE WORKED MORE THAN 1360
//            //TODO: IF PRECENTGES IS MORE THAN 70% IT WILL BE 70%
            return retirementSalary;
        }
        return 0;
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

