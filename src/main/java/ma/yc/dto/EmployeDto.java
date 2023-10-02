package ma.yc.dto;

import ma.yc.enums.Statusretaitre;
import ma.yc.model.Hourly_emp;
import ma.yc.model.SalaryHistory;
import ma.yc.model.Societe;

import java.util.Date;
import java.util.List;

public class EmployeDto {
    public Long matricule;
    public String nom;
    public String prenom;
    public String email;
    public Date dateNaissance;
    public String tel;
    public SocieteDto societe;
    public Statusretaitre retaitre;
    public List<Hourly_emp> jourTravaillesParMois;
    public List<SalaryHistory> salaires;
    public double salaire;
}
