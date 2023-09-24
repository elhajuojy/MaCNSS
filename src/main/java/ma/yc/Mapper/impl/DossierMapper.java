package ma.yc.Mapper.impl;

import ma.yc.dto.DossierDto;
import ma.yc.model.Dossier;

public class DossierMapper  {


    public Dossier toEntity(DossierDto dossierDto){
        Dossier dossier = new Dossier();
        dossier.setStatus(dossierDto.status);


        return dossier;
    };


}
