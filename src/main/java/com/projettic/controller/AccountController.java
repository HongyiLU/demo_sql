package com.projettic.controller;


import com.projettic.entity.Account;
import com.projettic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountServiceServivce;

    @RequestMapping(path = "/testAccountService")
    public String accountServiceTest() {
        List<Account> userList = accountServiceServivce.findAllUser();
        for(Account user:userList){
            System.out.println(user.toString());
        }
        return "success";
    }
}
