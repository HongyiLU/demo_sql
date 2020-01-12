package com.projettic.controller;

import com.projettic.dao.EmpDao;
import com.projettic.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class SqlTestController {


    private String sqlquery;
    public String getSqlquery() {
        return sqlquery;
    }
    @RequestMapping(path = "/hellotest" )
    public String helloTest(){
        System.out.println("Hello Spring MVC");
        return "success";
    }

    @RequestMapping(path = "/testsql")
    public String testSql(String sqlquery) throws IOException {
        System.out.println(sqlquery);
        this.sqlquery=sqlquery;
        InputStream in = Resources.getResourceAsStream("Mybatis/SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        EmpDao empDao = session.getMapper(EmpDao.class);

        List<Emp> emps = empDao.findAll();

        for(Emp emp:emps){
            System.out.println(emp.toString());
        }

        session.close();
        in.close();
        return "sql_query";
    }
}
