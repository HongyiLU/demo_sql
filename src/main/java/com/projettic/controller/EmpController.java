package com.projettic.controller;

import com.projettic.entity.Emp;
import com.projettic.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    private String sqlquery;

    @RequestMapping(path = "/testsql")
    public String getSqlQuery(String sqlquery){
        System.out.println(sqlquery);
        this.sqlquery=sqlquery;
        return "success";
    }
}
