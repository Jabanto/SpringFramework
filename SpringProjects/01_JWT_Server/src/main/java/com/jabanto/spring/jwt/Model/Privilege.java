package com.jabanto.spring.jwt.Model;

public class Privilege {

    private  String name;

    public Privilege(){}

    public Privilege(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
