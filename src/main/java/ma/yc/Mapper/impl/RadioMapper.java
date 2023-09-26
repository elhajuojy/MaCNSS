package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.RadioDto;
import ma.yc.model.Radio;

import java.sql.PreparedStatement;

public class RadioMapper implements Mapper<RadioDto, Radio> {
    @Override
    public Radio toEntity() {
        return null;
    }

    @Override
    public Radio toEntity(RadioDto radioDto) {
        Radio radio = new Radio();
        radio.setRadioId(radioDto.radioId);
        radio.setPrix(radioDto.prix);
        radio.setDescription(radioDto.description);

        return radio;
    }

    @Override
    public RadioDto toDto() {
        return null;
    }

    @Override
    public RadioDto toDto(Radio radio) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Radio radio, PreparedStatement preparedStatement) {
        return null;
    }
}
