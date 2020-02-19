package com.projettic.service.impl;

import com.projettic.dao.AccountDao;
import com.projettic.entity.Account;
import com.projettic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAllUser() {
        return accountDao.findAllUser();
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveUserAccount(account);
    }


}
