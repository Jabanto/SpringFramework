package com.javano.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class UniStudent_ConfigNotificated implements Student{

    public UniStudent_ConfigNotificated()
    {
        System.out.println("--Building student...--");
    }

    @Override
    public int realiseTest() {
        return (int)(Math.random()*10.0);

    }

    @PostConstruct
    public void prepareStudent(){
        System.out.println("Preparing the new Student to come at the Uni");
    }

    @PreDestroy
    public void sayGodByStudent(){
        System.out.println("Finally , we can say Goodbye this Student");
    }






}
