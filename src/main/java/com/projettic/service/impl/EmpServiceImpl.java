package com.projettic.service.impl;

import com.projettic.dao.impl.EmpDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpServiceImpl implements com.projettic.service.EmpService {

    @Autowired
    EmpDaoImpl empDao;
    String res;
    String hisRes;

    @Autowired
    public EmpServiceImpl() throws SQLException {
        this.res = "";
        this.hisRes = "";
    }

    public void setEmpDao(EmpDaoImpl empDao) {
        this.empDao = empDao;
    }

    @Override
    public String getHisReq(String hisReq) {
        try {
            ResultSet result = empDao.getResult(hisReq);
            while (result.next()) {
                String empNom = result.getString("nom_emp");
                hisRes += empNom + " ";
            }
            ResultSet resultSetExecutionPlan = empDao.getResult("explain "+hisReq);
            resultSetExecutionPlan.next();
            System.out.println("this is the execution plan");
            System.out.println(resultSetExecutionPlan.getString("table"));
        } catch (SQLException | ClassNotFoundException e) {
            return e.getMessage();
        }
        if (hisRes.length() < 3) {
            return "error";
        } else {
            return hisRes;
        }
    }

    @Override
    public String getCorrection() {
        try {
            ResultSet result = empDao.getResult("SELECT nom_emp FROM emp;");
            while (result.next()) {
                String empNom = result.getString("nom_emp");
                res += empNom + " ";
            }
        } catch (SQLException | ClassNotFoundException e) {
            return e.getMessage();
        }
        if (res.length() < 3) {
            System.out.println("this is correction"+res);
            return "error";
        } else {
            return res;
        }
    }
}
