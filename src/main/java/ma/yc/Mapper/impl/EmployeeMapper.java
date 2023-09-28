package ma.yc.Mapper.impl;

import java.sql.PreparedStatement;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.EmployeDto;
import ma.yc.model.Employe;

public class EmployeeMapper implements Mapper<EmployeDto, Employe> {


    @Override
    public Employe toEntity() {
        return null;
    }

    @Override
    public Employe toEntity(EmployeDto employeDto) {
        return null;
    }

    @Override
    public EmployeDto toDto() {
        return null;
    }

    @Override
    public EmployeDto toDto(Employe employe) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Employe employe, PreparedStatement preparedStatement) {
        return null;
    }
}
