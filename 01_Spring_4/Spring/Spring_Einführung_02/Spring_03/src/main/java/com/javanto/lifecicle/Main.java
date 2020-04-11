package com.javanto.lifecicle;

import com.javano.beans.Sun;
import com.javano.beans.UniStudent;
import com.javano.beans.UniStudent_ConfigNotificated;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext("com");
        // TODO: 04.05.2018 Martin Questions
        /**
         * Sun sun = applicationContext.getBean("sun",Sun.class);
            System.out.println(sun.getMesage());
         */

        /**
         * Life Cicle with implemntation of Interface @InitilizingBean and @DisposableBean
         */

        //UniStudent uniStudent = applicationContext.getBean("uniStudent",UniStudent.class);
        //applicationContext.close();

        /**
         * Life Cicle controling with Methods in our Bean and Annotations @PostConstructor and @PreDestroy
         */
        //UniStudent_ConfigNotificated uniStudent_configNotificated = applicationContext.getBean("uniStudent_ConfigNotificated",UniStudent_ConfigNotificated.class);
    }

}
