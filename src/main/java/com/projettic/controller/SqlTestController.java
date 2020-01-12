package com.projettic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SqlTestController {

    @RequestMapping(path = "/hellotest" )
    public String helloTest(){
        System.out.println("Hello Spring MVC");
        return "success";
    }
}
