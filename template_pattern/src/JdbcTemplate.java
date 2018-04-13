
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AYL    2018/4/12 22:55
 */
public class JdbcTemplate {
    private DateSource dateSource;

    public JdbcTemplate(DateSource dateSource) {
        this.dateSource = dateSource;
    }

    private Connection getDateSource(){
        return this.dateSource.getConnection();
    }

    private void closeResultSet(ResultSet resultSet){
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeStatement(PreparedStatement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement getStatement(Connection c,String sql) throws SQLException {
        PreparedStatement preparedStatement = c.prepareStatement(sql);
        return preparedStatement;
    }

    private ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }
    private List<?> resultHandler(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        int rowNum = 0;
        List<Object> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return result;
    }

    public List<?> executorQuery(String sql,RowMapper rowMapper) throws SQLException {
        /**1. 得到连接
         * 2. 得到语句集
         * 3. 得到结果集
         * 4. 操作结果集
         * 5. 关闭结果集
         * 6. 关闭语句集
         * 7. 关闭连接
         */
        Connection c = this.getDateSource();

        PreparedStatement preparedStatement = getStatement(c, sql);

        ResultSet resultSet = getResultSet(preparedStatement);

        List<?> result = resultHandler(resultSet,rowMapper);

        closeResultSet(resultSet);

        closeStatement(preparedStatement);

        closeConnection(c);

        return  result;
    }
}
