package com.projettic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.projettic.dao.EmpDao;
import com.projettic.entity.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements com.projettic.service.EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public String getHisRes(SqlQuery sqlQuery){
        try {
            List<LinkedHashMap<String, Object>> empList = empDao.getHisResult(sqlQuery);
            JSONArray jsonArray = new JSONArray();
            for(LinkedHashMap linkedHashMap : empList){
                JSONObject jsonObject = new JSONObject(linkedHashMap);
                jsonArray.add(jsonObject);
                System.out.println(jsonArray);
            }
            return jsonArray.toString();
        } catch (Exception e){
            System.out.println(e.getClass());
            return e.getMessage();
        }

    }

    @Override
    public String getCorrection() {
        return null;
    }
}
