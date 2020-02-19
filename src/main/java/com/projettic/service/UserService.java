package com.projettic.service;

import com.projettic.entity.User;

public interface UserService {
    User checkLogin(String username, String password);
}
