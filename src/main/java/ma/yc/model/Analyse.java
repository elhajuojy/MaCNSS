package ma.yc.model;

public class Analyse {
    private long AnalyseId;
    private float prix;

    private String description;
    private Dossier dossier;

    public long getAnalyseId() {
        return AnalyseId;
    }

    public void setAnalyseId(long analyseId) {
        AnalyseId = analyseId;
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
