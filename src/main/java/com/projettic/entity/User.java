package com.projettic.entity;

public class User {
    private int iduser;
    private String username;
    private String userpassword;
    private String useremail;
    private String userclass;

    public int getIduser() {
        return iduser;
    }

    public String getUsername() {
        return username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public String getUserclass() {
        return userclass;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass;
    }

    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", useremail='" + useremail + '\'' +
                ", userclass='" + userclass + '\'' +
                '}';
    }
}
