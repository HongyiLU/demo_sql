package com.projettic.dao;

import com.projettic.entity.User;

public interface UserDao {
    public User findUserByName(String username);
    public User getUserByEmail(String emailAddress);
    public User getUserById(Integer userId);
}
