package com.javano.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component()
@Scope(value = "singleton")
public class UniStudent implements Student, InitializingBean,DisposableBean {

    public UniStudent() {

        System.out.println("---an UniStudent Building---");
    }

    @Override
    public int realiseTest() {
        return (int)(Math.random()*10.0);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Welcomme Student to your new second House");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Fly free with your own wings :P ..ciau Bean ");
    }
}
