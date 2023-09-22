package ma.yc.model;

import java.util.Date;

public class Fichier {
    private long numeroFicher;
    private Date dateDepot;
    private float totalFraisDossier;
    private String specialite;

    private Dossier dossier;


    public long getNumeroFicher() {
        return numeroFicher;
    }

    public void setNumeroFicher(long numeroFicher) {
        this.numeroFicher = numeroFicher;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public float getTotalFraisDossier() {
        return totalFraisDossier;
    }

    public void setTotalFraisDossier(float totalFraisDossier) {
        this.totalFraisDossier = totalFraisDossier;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
