package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.DossierDto;
import ma.yc.model.Dossier;

import java.sql.PreparedStatement;

public class DossierMapper implements Mapper<DossierDto, Dossier> {


    @Override
    public Dossier toEntity() {
        //todo: implement this method to entity from DossierDto
        return null;
    }

    @Override
    public Dossier toEntity(DossierDto dossierDto) {
        //todo: implement this method to entity from DossierDto

        return null;
    }

    @Override
    public DossierDto toDto() {

        //todo: implement this method to dossierDto from DossierEntity

        return null;
    }

    @Override
    public DossierDto toDto(Dossier d) {
        DossierDto dossierDto = new DossierDto();
        dossierDto.numDossier = d.getNumDossier();
        dossierDto.status = d.getStatus();
        dossierDto.totalRemboursement = d.getTotalRemboursement();
        return dossierDto;
    }

    @Override
    public PreparedStatement toPreparedStatement(Dossier dossier, PreparedStatement preparedStatement) {
        return null;
    }
}
