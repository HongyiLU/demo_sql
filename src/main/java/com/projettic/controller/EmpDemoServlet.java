package com.projettic.controller;

import com.alibaba.fastjson.JSON;
import com.projettic.entity.SqlQuery;
import com.projettic.service.impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

//import com.projettic.service.impl.EmpServiceImpl;

@Controller
public class EmpDemoServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private EmpServiceImpl empServiceImpl;

    //private EmpDaoImpl empDao;
    public EmpDemoServlet() throws SQLException {
    }

//    @RequestMapping(path = "/jdbctest")
//    protected void init(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.getSession().setAttribute("res", empServiceImpl.getCorrection());
//        request.getRequestDispatcher("jdbcRes").forward(request, response);
//    }
//
//    @RequestMapping(path = "/jdbctest", method = RequestMethod.POST)
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String hisReq = request.getParameter("requete");
//        String hisRes = empServiceImpl.getHisRes(hisReq);
//        request.getSession().setAttribute("lmao", hisRes);
//        request.getRequestDispatcher("jdbcHisRes").forward(request, response);
//    }

    @RequestMapping(path = "/jdbcRes")
    protected String Res() {
        return "proto";
    }

    @RequestMapping(path = "/jdbcHisRes")
    protected String hisRes() throws Exception {
        return "proto";
    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/testsql", method = RequestMethod.POST)
    @ResponseBody()
    public String testsql1(@RequestBody String param, HttpServletRequest request) {
        System.out.println(request.getMethod());
        System.out.println(request.getHeader("Content-Type"));
        SqlQuery sqlQuery = JSON.parseObject(param, SqlQuery.class);
        System.out.println(sqlQuery.toString());
        String hisRes = empServiceImpl.getHisRes(sqlQuery);
        System.out.println(hisRes);
        return hisRes;
    }
}
