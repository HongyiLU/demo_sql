package com.projettic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(path="/testGit")
    public String testGit(){ return "success";}

    @CrossOrigin
    @RequestMapping(path = "/testLogin")
    public String userLoginTestPage() {
        return "success";
    }
}
