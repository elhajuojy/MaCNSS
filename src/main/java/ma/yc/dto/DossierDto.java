package ma.yc.dto;

import ma.yc.enums.statusDossier;
import ma.yc.model.Fichier;

public class DossierDto {
    public String num_dossier ;
    public String matricule;
    public statusDossier status;



    public DossierDto() {
    }

    public DossierDto(String num_dossier, String matricule) {
        this.num_dossier = num_dossier;
        this.matricule = matricule;
        this.status = statusDossier.En_attend;
    }
}
