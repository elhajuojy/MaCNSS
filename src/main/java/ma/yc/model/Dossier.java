package ma.yc.model;

import ma.yc.enums.statusDossier;

public class Dossier {
    private String numDossier;
    private statusDossier status;
    private float totalRemboursement;
    private Remboursement remboursement;
    private Fichier fichier;

    private Medicament medicament;
    private Analyse analyse;
    private Scanner scanner;
    private Radio radio;
    private Visite visite;


    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Analyse getAnalyse() {
        return analyse;
    }

    public void setAnalyse(Analyse analyse) {
        this.analyse = analyse;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Radio getRadio() {
        return radio;
    }

    public void setRadio(Radio radio) {
        this.radio = radio;
    }

    public Visite getVisite() {
        return visite;
    }

    public void setVisite(Visite visite) {
        this.visite = visite;
    }

    public Remboursement getRemboursement() {
        return remboursement;
    }

    public void setRemboursement(Remboursement remboursement) {
        this.remboursement = remboursement;
    }

    public String getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(String numDossier) {
        this.numDossier = numDossier;
    }

    public statusDossier getStatus() {
        return status;
    }

    public void setStatus(statusDossier status) {
        this.status = status;
    }

    public float getTotalRemboursement() {
        return totalRemboursement;
    }

    public void setTotalRemboursement(float totalRemboursement) {
        this.totalRemboursement = totalRemboursement;
    }

}
