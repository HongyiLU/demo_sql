package com.projettic.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class EmpDaoImpl implements com.projettic.dao.EmpDao {

    String strUrl;
    String strUsername;
    String strPW;

    @Autowired
    public EmpDaoImpl() {
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testtic?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "123456");
        return conn;

    }


    public ResultSet getResult(String SqlQuery) throws SQLException, ClassNotFoundException {
        Statement statement = this.getConnection().createStatement();
        ResultSet result = statement.executeQuery(SqlQuery);
        return result;
    }

}
