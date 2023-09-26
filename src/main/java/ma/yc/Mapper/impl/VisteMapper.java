package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.VisiteDto;
import ma.yc.model.Visite;

import java.sql.PreparedStatement;

public class VisteMapper implements Mapper<VisiteDto, Visite> {
    @Override
    public Visite toEntity() {
        return null;
    }

    @Override
    public Visite toEntity(VisiteDto visiteDto) {
        Visite visite = new Visite();
        visite.setVisiteId(visiteDto.visiteId);
        visite.setDescription(visiteDto.description);
        visite.setSpecialiteMedecin(visiteDto.specialiteMedecin);
        visite.setPrix(visiteDto.prix);
        return visite;
    }

    @Override
    public VisiteDto toDto() {
        return null;
    }

    @Override
    public VisiteDto toDto(Visite visite) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Visite visite, PreparedStatement preparedStatement) {
        return null;
    }
}
