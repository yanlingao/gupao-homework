package com.ayl.gupao.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author AYL    2018/4/6 23:10
 */
public class MyTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter + "_ayl");
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {

        return (rs.getString(columnName) == null || rs.getString(columnName).equals(""))? "this is a null value" : rs.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet rs, int i) throws SQLException {
        return (rs.getString(i) == null || rs.getString(i).equals("")) ? "this is a null value" : rs.getString(i);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int i) throws SQLException {
        return (cs.getString(i) == null || cs.getString(i).equals("")) ? "this is a null value" : cs.getString(i);
    }
}
