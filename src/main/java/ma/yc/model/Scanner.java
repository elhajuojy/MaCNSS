package ma.yc.model;

public class Scanner {
    private long scannerId;
    private float prix;

    private String description;
    private Dossier dossier;

    public long getScannerId() {
        return scannerId;
    }

    public void setScannerId(long scannerId) {
        this.scannerId = scannerId;
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
