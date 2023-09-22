package ma.yc.model;

public class Radio {
    private long radioId;
    private float prix;

    private String description;
    private Dossier dossier;

    public long getRadioId() {
        return radioId;
    }

    public void setRadioId(long radioId) {
        this.radioId = radioId;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
