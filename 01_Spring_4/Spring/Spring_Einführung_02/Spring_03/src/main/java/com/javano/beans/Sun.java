package com.javano.beans;

import org.springframework.stereotype.Component;

/**
 * Test Method to prove Initialitation beans in Spring
 */
@Component
public class Sun {

    private static Sun instance;

    static {

        instance = new Sun();
    }

    /**
     * Private Constructor
     */
    private Sun(){}

    public static Sun getInstance(){
        return instance;
    }

    /**
     * How ist posible to load this method , whenn constuctor private is?
     * @return
     */
    public String getMesage(){
        return "\n Hello to all Java-Developer :)";
    }

}
