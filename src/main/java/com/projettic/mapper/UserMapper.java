package com.projettic.mapper;

import com.projettic.entity.User;

public interface UserMapper {
    public User getUserByName(String userName);
    public User getUserByEmail(String emailAddress);
    public User getUserById(Integer userId);
}
