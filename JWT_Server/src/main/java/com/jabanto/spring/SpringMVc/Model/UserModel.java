package com.jabanto.spring.SpringMVc.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserModel {

    private long id;
    private String login;
    private String password;
    private String fName, lName;
    private String eMail;

    public UserModel() {
    }

    public UserModel(long id, String login, String password, String fName, String lName, String eMail) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.eMail = eMail;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + fName + '\'' +
                ", lastName='" + lName + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
