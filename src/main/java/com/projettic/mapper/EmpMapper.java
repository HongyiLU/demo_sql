package com.projettic.mapper;

import com.projettic.entity.Emp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Emp emp = new Emp();
        emp.setId_emp(resultSet.getInt("id_emp"));
        emp.setNom_emp(resultSet.getString("nom_emp"));
        return emp;
    }
}
