package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String sqltest(){
        return "sql_query";
    }

    @CrossOrigin(value="http://localhost:4200")
    @RequestMapping(path = "/testsql", method = RequestMethod.POST)
    public String testsql(@RequestBody String param, HttpServletRequest request) {
        System.out.println(request.getMethod());
        System.out.println(request.getHeader("Content-Type"));
        Hero hero = JSON.parseObject(param, Hero.class);
        System.out.println(hero.toString());
        return "success";
    }

}
