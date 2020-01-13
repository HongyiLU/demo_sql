package com.projettic.service;

import com.projettic.entity.Emp;

import java.util.List;

public interface EmpService {
    //find all emp
    List<Emp> findAll(String SQL);

    //add an emp
    void addEmp(Emp emp);
}
