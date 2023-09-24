package ma.yc.Mapper;

import java.sql.PreparedStatement;

public interface Mapper<D,E> {

    E toEntity();

    E toEntity(D d);

    D toDto();

    D toDto(D t);

    PreparedStatement toPreparedStatement(E e, PreparedStatement preparedStatement);

}
