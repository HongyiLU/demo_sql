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
public class TestController {

    @RequestMapping(path = "/hellotest")
    public String helloTest() {
        System.out.println("Hello Spring MVC");
        return "success";
    }

    @RequestMapping(path = "/sqltest")
    public String sqltest() {
        return "sql_query";
    }

}
