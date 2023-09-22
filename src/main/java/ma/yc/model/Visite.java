package ma.yc.model;

import ma.yc.enums.stMedecin;

public class Visite {
    private  long visiteId;
    private float prix;
    private stMedecin specialiteMedecin;
    private String description;
    private Dossier dossier;

    public long getVisiteId() {
        return visiteId;
    }

    public void setVisiteId(long visiteId) {
        this.visiteId = visiteId;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public stMedecin getSpecialiteMedecin() {
        return specialiteMedecin;
    }

    public void setSpecialiteMedecin(stMedecin specialiteMedecin) {
        this.specialiteMedecin = specialiteMedecin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
