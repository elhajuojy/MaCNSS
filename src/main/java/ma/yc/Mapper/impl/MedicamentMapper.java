package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.MedicamentDto;
import ma.yc.model.Medicament;

import java.sql.PreparedStatement;

public class MedicamentMapper implements Mapper<MedicamentDto, Medicament> {
    @Override
    public Medicament toEntity() {
        return null;
    }

    @Override
    public Medicament toEntity(MedicamentDto medicamentDto) {
        Medicament medicament = new Medicament();
        medicament.setCodeBarre(medicamentDto.codeBarre);
        medicament.setPrix(medicamentDto.prix);
        medicament.setQuantite(medicamentDto.quantite);

        return medicament;
    }

    @Override
    public MedicamentDto toDto() {
        return null;
    }

    @Override
    public MedicamentDto toDto(Medicament medicament) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Medicament medicament, PreparedStatement preparedStatement) {
        return null;
    }
}
