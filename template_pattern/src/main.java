import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author AYL    2018/4/13 6:50
 */
public class main {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

        String sql = "select * from table user";
        try {
            jdbcTemplate.executorQuery(sql, new RowMapper() {
                @Override
                public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setName(resultSet.getString(i));
                    user.setPassword(resultSet.getString(i));
                    return user;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
