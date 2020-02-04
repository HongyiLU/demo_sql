package com.projettic.controller;

import com.projettic.service.impl.EmpServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
public class servlet {
    private static final long serialVersionUID = 1L;

    private EmpServiceImpl empServiceImpl = new EmpServiceImpl();

    public servlet() throws SQLException {
    }



    @RequestMapping(path = "/jdbctest")
    protected void init(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getSession().setAttribute("res", empServiceImpl.getCorrection());
        request.getRequestDispatcher("jdbcRes").forward(request, response);
    }

    @RequestMapping(path = "/jdbctest",method = RequestMethod.POST)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String hisReq = request.getParameter("requete");
        String hisRes = empServiceImpl.getHisReq(hisReq);
        request.getSession().setAttribute("lmao", hisRes);
        request.getRequestDispatcher("jdbcHisRes").forward(request, response);
    }

    @RequestMapping(path = "/jdbcRes")
    protected String Res(){
        return "proto";
    }

    @RequestMapping(path = "/jdbcHisRes")
    protected String hisRes() throws Exception{
        return "proto";
    }

}