package ma.yc.model;

import ma.yc.enums.statusDossier;

import java.util.List;

public class Dossier {



    private String numDossier;
    private statusDossier status;
    private float totalRemboursement;
    private Remboursement remboursement;
    private Patient patient;
    private Fichier fichier;

    private List<Medicament> medicaments;
    private List<Analyse> analyses;
    private List<Scanner> scanners;
    private List<Radio> radios;
    private List<Visite> visites;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    public List<Analyse> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<Analyse> analyses) {
        this.analyses = analyses;
    }

    public List<Scanner> getScanners() {
        return scanners;
    }

    public void setScanners(List<Scanner> scanners) {
        this.scanners = scanners;
    }

    public List<Radio> getRadios() {
        return radios;
    }

    public void setRadios(List<Radio> radios) {
        this.radios = radios;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }

    public Fichier getFichier() {
        return fichier;
    }

    public void setFichier(Fichier fichier) {
        this.fichier = fichier;
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
