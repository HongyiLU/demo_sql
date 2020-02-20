package com.projettic.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Account;
import com.projettic.entity.StatusCode;
import com.projettic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/testAccountService")
    public String accountServiceTest() {
        List<Account> userList = accountService.findAllUser();
        for(Account user:userList){
            System.out.println(user.toString());
        }
        return "success";
    }

    @RequestMapping(path = "user/testlogin")
    public String userLoginTestPage() {
        return "success";
    }

    @RequestMapping(path = "user")
    public String userLoginPage() {
        return "login";
    }

    //@CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/user/getloginfo", method = RequestMethod.POST)
    @ResponseBody()
    public String userLogin(HttpServletRequest req, HttpServletResponse res) {
        Account account = new Account();
        account.setUsername(req.getParameter("username"));
        account.setEmail(req.getParameter("username"));
        account.setPassword(req.getParameter("password"));
        account.setGroupid(Integer.parseInt(req.getParameter("groupid")));
        if(accountService.checkAccount(account)!=null){
            req.getSession().setAttribute("EMAIL", account.getEmail());
            String jsonString = JSON.toJSONString(accountService.checkAccount(account));
            res.addCookie(new Cookie("EMAIL", account.getEmail()));
            System.out.println("Loggin successfully");
            return jsonString;
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode",StatusCode.NOT_LOGIN.getCode());
            jsonObject.put("ErrorMessage",StatusCode.NOT_LOGIN.getMessage());
            return jsonObject.toString();
        }
    }

    //@CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/user/login")
    public String userLogin() {
        return "login";
    }

    @RequestMapping(path = "/user/errorlogin")
    @ResponseBody
    public String notLoginWarning() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ErrorCode",StatusCode.NOT_LOGIN.getCode());
        jsonObject.put("ErrorMessage",StatusCode.NOT_LOGIN.getMessage());
        return jsonObject.toString();
    }
}
