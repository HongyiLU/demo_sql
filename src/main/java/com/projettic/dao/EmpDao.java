package com.projettic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmpDao {
    ResultSet getResult(String SqlQuery) throws SQLException;
}
