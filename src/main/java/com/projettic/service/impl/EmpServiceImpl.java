package com.projettic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.projettic.dao.impl.EmpDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
@Service
public class EmpServiceImpl implements com.projettic.service.EmpService {

    @Autowired
    private EmpDaoImpl empDao;

    @Autowired
    public EmpServiceImpl() throws SQLException {
    }


    public void setEmpDao(EmpDaoImpl empDao) {
        this.empDao = empDao;
    }

    @Override
    public String getHisRes(String hisReq){
        JSONArray array = new JSONArray();
        try {
            ResultSet rs = empDao.getResult(hisReq);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                JSONObject jsonObj = new JSONObject(new LinkedHashMap());
                // 遍历每一列
                for (int i = 1; i <= columnCount; i++) {
                    String columnName =metaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    jsonObj.put(columnName, value);
                    System.out.println(jsonObj.toString());
                }
                array.add(jsonObj);
            }
            return array.toString();
//            ResultSet resultSetExecutionPlan = empDao.getResult("explain "+hisReq);
//            resultSetExecutionPlan.next();
//            System.out.println("this is the execution plan");
//            System.out.println(resultSetExecutionPlan.getString("table"));
        } catch (Exception e){
            return e.getMessage();
        }

    }

    @Override
    public String getCorrection() {
        String res = "";
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
