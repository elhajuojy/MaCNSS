package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.SocieteDto;
import ma.yc.model.Societe;

import java.sql.PreparedStatement;
import java.time.chrono.IsoEra;

public class SocieteMapper implements Mapper<SocieteDto, Societe> {
    @Override
    public Societe toEntity() {
        return null;
    }

    @Override
    public Societe toEntity(SocieteDto societeDto) {
        Societe societe = new Societe();
        societe.setEmail(societeDto.email);
        societe.setPassword(societeDto.id.toString());
        societe.setId(societeDto.id);
        societe.setTel(societeDto.tel);
        societe.setNom(societeDto.nom);
        societe.setAdresse(societeDto.adresse);
        //TODO : EMPLOYES MAPPER BROUH
        societe.setEmployes(null);
        return societe;
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
