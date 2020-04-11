package com.collections.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Person {


    private int age;
    private String name;

    public Person(){}

    @Override
    public String toString()
    {
        return new StringBuilder("nombre: ").append(name).append(", edad: ").append(age).toString();
    }

    /**
     * Region Setter un Getter
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


}
