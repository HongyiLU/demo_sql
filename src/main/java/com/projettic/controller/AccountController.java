package com.projettic.controller;


import com.alibaba.fastjson.JSONObject;
import com.projettic.entity.Account;
import com.projettic.entity.StatusCode;
import com.projettic.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/user")
public class AccountController {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/testlogin")
    public String userLoginTestPage() {
        return "success";
    }

    //@CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/getloginfo", method = RequestMethod.POST)
    @ResponseBody()
    public String userLogin(Account account, HttpServletRequest req, HttpServletResponse res) {
        account.setEmail(req.getParameter("username"));
        if(accountService.checkAccount(account)!=null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("Data", accountService.checkAccount(account));
            req.getSession().setAttribute("EMAIL", account.getEmail());
            res.addCookie(new Cookie("EMAIL", account.getEmail()));
            logger.info("Login - " + account.getUsername());
            return jsonObject.toString();
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode", StatusCode.UNAUTHORIZED.getCode());
            jsonObject.put("ErrorMessage", StatusCode.UNAUTHORIZED.getMessage());
            logger.info("Login not success - " + account.getUsername());
            return jsonObject.toString();
        }
    }

    //@CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(path = "/login")
    public String userLogin() {
        return "login";
    }

    @RequestMapping(path = "/errorlogin")
    @ResponseBody
    public String notLoginWarning() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ErrorCode", StatusCode.NOT_LOGIN.getCode());
        jsonObject.put("ErrorMessage", StatusCode.NOT_LOGIN.getMessage());
        return jsonObject.toString();
    }

    @RequestMapping(path = "/registerinfo", method = RequestMethod.POST)
    @ResponseBody
    public String userRegister(Account account) {
        try {
            account.setGroupid(2);
            accountService.saveAccount(account);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ErrorCode", StatusCode.SUCCESS.getCode());
            jsonObject.put("Data", accountService.checkAccount(account));
            logger.info("User registered - " + jsonObject.toString());
            return jsonObject.toString();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }

    @RequestMapping(path = "/register")
    public String userRegisterPage() {
        return "register";
    }
}
