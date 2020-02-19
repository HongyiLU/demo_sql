//package com.projettic.service.impl;
//
//import com.projettic.dao.UserDao;
//import com.projettic.entity.User;
//import com.projettic.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public User checkLogin(String username, String userpassword) {
//        User user = userDao.findByUsername(username);
//        if(user != null && user.getUserpassword().equals(userpassword)){
//
//            return user;
//        }
//        return null;
//    }
//}
