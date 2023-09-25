package ma.yc.Mapper;

import java.sql.PreparedStatement;

public interface Mapper<D,E> {

    E toEntity();

    E toEntity(D d);

    D toDto();
    //todo:here should toDto D toDto(E , T)
    D toDto(E e);

    PreparedStatement toPreparedStatement(E e, PreparedStatement preparedStatement);

}