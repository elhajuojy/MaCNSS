package ma.yc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.enums.Statusretaitre;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
//todo : employe :: slaiare history :: jour travaillé :: matricule :: nom :: prenom :: email :: date naissance :: tel :: societe :: retraitre
public class Employe extends Utilisateur {
    //chaque employé doit cumulé au minimum 1320 jours dans sa carrière professionnelle si un employé change de socité,
    // il garde le même matricule avec changement de société qu'elle a employé
    private Long matricule;
    private String nom;
    private String prenom;
    private String email;
    private Date dateNaissance;
    private String tel;
    private Societe societe;
    private Statusretaitre retaitre;
    private List<Hourly_emp> jourTravaillesParMois;
    private List<SalaryHistory> salaires;
    private double salaire;
}
