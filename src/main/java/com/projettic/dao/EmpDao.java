package com.projettic.dao;

import com.projettic.entity.Emp;

import javax.sql.DataSource;
import java.util.List;

public interface EmpDao {

    public void setDataSource(DataSource ds);

    //find all emp
    List<Emp> findAll(String SQL);

    //add an emp
    void addEmp(Emp emp);
}
