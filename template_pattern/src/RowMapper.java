import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author AYL    2018/4/13 6:22
 */
public interface RowMapper<T> {
    public T mapRow(ResultSet resultSet, int i) throws SQLException;
}
