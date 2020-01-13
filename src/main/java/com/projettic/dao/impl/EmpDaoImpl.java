package com.projettic.dao.impl;

import com.projettic.dao.EmpDao;
import com.projettic.entity.Emp;
import com.projettic.mapper.EmpMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
    }

    @Override
    public List<Emp> findAll(String SQL) {
        System.out.println("findAll called");
        List<Emp> emps = jdbcTemplateObject.query(SQL,new EmpMapper());
        return emps;
    }

    @Override
    public void addEmp(Emp emp) {

    }

    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
    }
}
