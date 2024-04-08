//* Coder: NGUYEN DOAN CHI THUC
//* Date of writing code: 04/10/2021
//* MSSV: PC01573
//* Class: IT16301
package com.software.jdbcHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class XJdbc {

    static Connection connection;
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost; database = QuanLyShopTheThaoPingPong";//sai dấu 2 chấm thành 1 chấm :))
    public static String useSql = "sa";
    public static String passSql = "123";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException{
        connection = DriverManager.getConnection(url, useSql, passSql);
        PreparedStatement statement;
        if (sql.trim().startsWith("{")) {
            statement = connection.prepareCall(sql);
        } else {
            statement = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
        return statement;
    }

    public static int update(String sql, Object... args) throws SQLException{
        PreparedStatement statement = XJdbc.getStmt(sql, args);
        try {
            return statement.executeUpdate();
        } finally {
            statement.getConnection().close();
        }
    }

    public static ResultSet query(String sql, Object... args) throws SQLException{
        PreparedStatement statement = XJdbc.getStmt(sql, args);
        return statement.executeQuery();
    }

    @SuppressWarnings("UseOfIndexZeroInJDBCResultSet")
    public static Object values(String sql, Object... args) throws SQLException{
        ResultSet resultSet = XJdbc.query(sql, args);
        if (resultSet.next()) {
            return resultSet.getObject(0);
        }
        resultSet.getStatement().getConnection().close();
        return null;
    }
}
