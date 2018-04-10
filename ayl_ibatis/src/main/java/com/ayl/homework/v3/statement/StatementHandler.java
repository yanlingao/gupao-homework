package com.ayl.homework.v3.statement;

import com.ayl.homework.entity.Test;

import java.sql.*;

/**
 * @author AYL    2018/4/4 21:40
 */
public class StatementHandler {
    public ResultSet query(String statement, Object parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.11.88:3306/gp?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "ayl123456");
            String sql = String.format(statement, (Integer) parameter);
            System.out.println("sql:" + sql);
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
