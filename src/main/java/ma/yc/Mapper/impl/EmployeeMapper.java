package ma.yc.Mapper.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.EmployeDto;
import ma.yc.dto.SalaryHistoryDto;
import ma.yc.dto.SocieteDto;
import ma.yc.model.Employe;
import ma.yc.model.SalaryHistory;
import ma.yc.model.Societe;

public class EmployeeMapper implements Mapper<EmployeDto, Employe> {

    private Mapper<SocieteDto , Societe> societeMapper ;
    private Mapper<SalaryHistoryDto,SalaryHistory> salaryHistoryMapper ;

    public EmployeeMapper() {
        this.societeMapper = new SocieteMapper();
//        this.salaryHistoryMapper = new SalaryHistory();
    }

    @Override
    public Employe toEntity() {
        return null;
    }

    @Override
    public Employe toEntity(EmployeDto employeDto) {
        Employe employe = new Employe();
        employe.setMatricule(employeDto.matricule);
        employe.setNom(employeDto.nom);
        employe.setPrenom(employeDto.prenom);
        employe.setEmail(employeDto.email);
        //TODO : convert the date from string to date
        try{
            if (employeDto.dateNaissance != null){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date date = simpleDateFormat.parse(employeDto.dateNaissance);
                employe.setDateNaissance(new Date(date.getTime()));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        employe.setTel(employeDto.tel);
//        employe.setSociete(new Societe());
//        employe.getSociete().setId(employeDto.societe.id);
//        employe.getSociete().setNom(employeDto.societe.nom);
        employe.setSociete(this.societeMapper.toEntity(employeDto.societe));
        employe.setRetaitre(employeDto.retaitre);
        //each mnoth work days history
        employe.setJourTravaillesParMois(employeDto.jourTravaillesParMois);
        //salaire history
        employe.setSalaires(employeDto.salaires);
        //salaire Actuel
        employe.setSalaire(employeDto.salaire);



        return employe;

    }

    @Override
    public EmployeDto toDto() {
        return null;
    }

    @Override
    public EmployeDto toDto(Employe employe) {
        EmployeDto employeDto = new EmployeDto();
        employeDto.matricule = employe.getMatricule();
        employeDto.nom = employe.getNom();
        employeDto.prenom = employe.getPrenom();
        employeDto.email = employe.getEmail();
        employeDto.dateNaissance = employe.getDateNaissance().toString();
        employeDto.tel = employe.getTel();
        if (employe.getJourTravaillesParMois() !=null || !(employe.getJourTravaillesParMois().size() <1)){
            employeDto.nombreJourTravaille  = employe.getJourTravaillesParMois().stream().map(num ->num.getJourTravaille()).reduce(0, Integer::sum);
        }
        employeDto.societe = this.societeMapper.toDto(employe.getSociete());
        employeDto.retaitre = employe.getRetaitre();
        employeDto.jourTravaillesParMois = employe.getJourTravaillesParMois();
        employeDto.salaires = employe.getSalaires();
        employeDto.salaire = employe.getSalaire();
        return employeDto;
    }

    @Override
    public PreparedStatement toPreparedStatement(Employe employe, PreparedStatement preparedStatement) {
        return null;
    }
}
