package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.AnalyseDto;
import ma.yc.model.Analyse;

import java.sql.PreparedStatement;

public class AnalyseMapper implements Mapper<AnalyseDto, Analyse> {
    @Override
    public Analyse toEntity() {
        return null;
    }

    @Override
    public Analyse toEntity(AnalyseDto analyseDto) {
        Analyse analyse = new Analyse();
        analyse.setAnalyseId(analyseDto.analyseId);
        analyse.setPrix(analyseDto.prix);
        analyse.setDescription(analyseDto.description);

        return analyse;
    }

    @Override
    public AnalyseDto toDto() {
        return null;
    }

    @Override
    public AnalyseDto toDto(Analyse analyse) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Analyse analyse, PreparedStatement preparedStatement) {
        return null;
    }
}
