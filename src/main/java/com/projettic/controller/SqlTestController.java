package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.sqlQuery;
import com.projettic.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SqlTestController {
    private String hisRes;
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
    public void testsql(@RequestBody String param, HttpServletRequest request) {
        System.out.println(request.getMethod());
        System.out.println(request.getHeader("Content-Type"));
        sqlQuery sqlQuery = JSON.parseObject(param, sqlQuery.class);
        System.out.println(sqlQuery.toString());
        this.hisRes = empServiceImpl.getHisRes(sqlQuery.toString());
        System.out.println(hisRes);
    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/testsql", method = RequestMethod.GET)
    @ResponseBody
    public String testsql2(HttpServletRequest request) {
        System.out.println(request.getMethod());
        return this.hisRes;
    }

}
