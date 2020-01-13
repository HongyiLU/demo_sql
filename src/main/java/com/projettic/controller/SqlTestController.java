package com.projettic.controller;

import com.projettic.dao.EmpDao;
import com.projettic.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class SqlTestController {
    @RequestMapping(path = "/hellotest" )
    public String helloTest(){
        System.out.println("Hello Spring MVC");
        return "success";
    }

    @RequestMapping(path = "/sqlquery")
    public String testSql() throws IOException {
        return "sql_query";
    }


}
