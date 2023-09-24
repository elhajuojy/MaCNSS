package ma.yc.Mapper.impl;
import ma.yc.Mapper.Mapper;
import ma.yc.dto.UserDto;
import ma.yc.model.Utilisateur;

import java.sql.PreparedStatement;

public class UserMapper implements Mapper<UserDto, Utilisateur> {


    @Override
    public Utilisateur toEntity() {
        return null;
    }

    @Override
    public Utilisateur toEntity(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto toDto() {
        return null;
    }

    @Override
    public UserDto toDto(UserDto t) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Utilisateur utilisateur, PreparedStatement preparedStatement) {
        return null;
    }
}
