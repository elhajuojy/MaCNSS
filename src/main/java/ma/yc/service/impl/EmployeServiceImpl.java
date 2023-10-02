package ma.yc.service.impl;

import ma.yc.dto.EmployeDto;
import ma.yc.enums.Statusretaitre;
import ma.yc.service.EmployeeService;

import java.util.Date;

public class EmployeServiceImpl implements EmployeeService {


    @Override
    public EmployeDto addEmployee(EmployeDto employeeDto) {
        return this.dumpEmployee();
    }

    @Override
    public EmployeDto consultEmployee(long employeeMatricule) {
        // TODO : implement CONSULT EMPLOYEE
        return  this.dumpEmployee();
    }

    private EmployeDto dumpEmployee() {
        EmployeDto employeDto = new EmployeDto();
        employeDto.matricule = 1L;
        employeDto.nom = "nom";
        employeDto.prenom = "prenom";
        employeDto.email = "email";
        employeDto.dateNaissance = new Date();
        employeDto.tel = "tel";
        employeDto.retaitre = Statusretaitre.OUI;
        employeDto.jourTravaillesParMois = null;
        employeDto.salaires = null;
        employeDto.salaire = 1244.22;
        return employeDto;
    }

    @Override
    public boolean isEmployeeExist(int id) {
        if (true){
            return  true;
        }
        return false;
    }

    @Override
    public boolean updateEmployeeSalary(int id, double salary) {
        if (true){
            return  true;
        }
        return false;
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

