package com.projettic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SqlTestController {
    @RequestMapping(path = "/hellotest" )
    public String helloTest(){
        System.out.println("Hello Spring MVC");
        return "success";

    }

    @RequestMapping(path = "/sqltest")
    public String testSql() throws IOException {
        return "sql_query";
    }


}
