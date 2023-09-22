package ma.yc.Mapper;

import java.sql.PreparedStatement;

public interface Mapper<T> {

    T toEntity();

    T toEntity(T t);

    T toDto();

    T toDto(T t);

    PreparedStatement toPreparedStatement(T t, PreparedStatement preparedStatement);

}
