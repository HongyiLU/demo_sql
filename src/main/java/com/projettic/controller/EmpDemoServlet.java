package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.SqlQuery;
import com.projettic.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class EmpDemoServlet {

    @Autowired
    private EmpServiceImpl empServiceImpl;

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/testsql", method = RequestMethod.POST)
    @ResponseBody()
    public String testsql1(@RequestBody String param) {
        SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
        System.out.println(sqlQuery.toString());
        String hisRes = empServiceImpl.getHisRes(sqlQuery);
        System.out.println(hisRes);
        return hisRes;
    }
}
