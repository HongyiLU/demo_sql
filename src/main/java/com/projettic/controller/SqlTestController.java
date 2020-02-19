package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.SqlQuery;
import com.projettic.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

@Controller
public class SqlTestController {
    @Autowired
    private EmpServiceImpl empServiceImpl;

    @RequestMapping(path = "/hellotest")
    public String helloTest() {
        System.out.println("Hello Spring MVC");
        return "success";
    }

    @RequestMapping(path = "/sqltest")
    public String sqltest() {
        return "sql_query";
    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/testsql", method = RequestMethod.POST)
    @ResponseBody()
    public String testsql1(@RequestBody String param, HttpServletRequest request) {
        System.out.println(request.getMethod());
        System.out.println(request.getHeader("Content-Type"));
        SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
        System.out.println(sqlQuery.toString());
        String hisRes = empServiceImpl.getHisRes(sqlQuery.toString());
        System.out.println(hisRes);
        return hisRes;
    }


}
