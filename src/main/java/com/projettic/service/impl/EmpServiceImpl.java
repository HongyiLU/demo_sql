package com.projettic.service.impl;

import com.projettic.dao.impl.EmpDaoImpl;
import com.projettic.entity.Emp;
import com.projettic.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDaoImpl empDao;

    @Override
    public List<Emp> findAll(String SQL) {
        return empDao.findAll(SQL);
    }

    @Override
    public void addEmp(Emp emp) {
        System.out.println("addEmp called");
    }

    public void setEmpDao(EmpDaoImpl empDao) {
    }
}
