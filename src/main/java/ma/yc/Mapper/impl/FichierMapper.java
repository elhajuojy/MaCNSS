package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.FichierDto;
import ma.yc.model.Fichier;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class FichierMapper implements Mapper<FichierDto,Fichier> {
    @Override
    public Fichier toEntity() {
        return null;
    }

    @Override
    public Fichier toEntity(FichierDto fichierDto) {
        Fichier fichier = new Fichier();

        try{
            if (fichierDto.dateDepot != null){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date date = simpleDateFormat.parse(fichierDto.dateDepot);
                fichier.setDateDepot(new Date(date.getTime()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        fichier.setSpecialite(fichierDto.specialite);
        fichier.setNumeroFicher(fichierDto.numeroFicher);
        fichier.setTotalFraisDossier(fichierDto.totalFraisDossier);
        return fichier;
    }

    @Override
    public FichierDto toDto() {
        return null;
    }

    @Override
    public FichierDto toDto(Fichier fichier) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Fichier fichier, PreparedStatement preparedStatement) {
        return null;
    }
}
