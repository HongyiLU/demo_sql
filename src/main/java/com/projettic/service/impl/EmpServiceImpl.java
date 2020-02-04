package com.projettic.service.impl;

import com.projettic.dao.impl.EmpDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpServiceImpl implements com.projettic.service.EmpService {

    EmpDaoImpl empDao;
    String res;
    String hisRes;

    public EmpServiceImpl() throws SQLException {
        this.res = "";
        this.hisRes = "";
        this.empDao = new EmpDaoImpl();
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
        } catch (SQLException e) {
            return e.toString();
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
        } catch (SQLException e) {

        }
        if (res.length() < 3) {
            return "error";
        } else {
            return res;
        }
    }
}
