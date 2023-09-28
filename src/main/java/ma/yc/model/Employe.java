package ma.yc.model;

public class Employe extends Utilisateur {
    //chaque employé doit cumulé au minimum 1320 jours dans sa carrière professionnelle si un employé change de socité,
    // il garde le même matricule avec changement de société qu'elle a employé
    private Long matricule;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
//    private Societe societe;
    private boolean retaitre;
    private double salaire;
}

