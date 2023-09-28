package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.SocieteDto;
import ma.yc.model.Societe;

import java.sql.PreparedStatement;

public class SocieteMapper implements Mapper<SocieteDto, Societe> {
    @Override
    public Societe toEntity() {
        return null;
    }

    @Override
    public Societe toEntity(SocieteDto societeDto) {
        return null;
    }

    @Override
    public SocieteDto toDto() {
        return null;
    }

    @Override
    public SocieteDto toDto(Societe societe) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Societe societe, PreparedStatement preparedStatement) {
        return null;
    }
}
