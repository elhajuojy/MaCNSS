package ma.yc.model;

import java.util.List;


public class Patient  extends Utilisateur{
    private String matricule;

    private String nom;
    private List<Dossier> dossiers;


    public String getMatricule() {
        return matricule;
    }

    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Dossier> dossiers) {
        this.dossiers = dossiers;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
