package com.projettic.entity;

public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_mail;
    private String user_class;

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public String getUser_class() {
        return user_class;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setUser_class(String user_class) {
        this.user_class = user_class;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_mail='" + user_mail + '\'' +
                ", user_class='" + user_class + '\'' +
                '}';
    }
}
