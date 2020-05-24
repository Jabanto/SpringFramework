package org.example.internal.anotaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.applet.Main;

public class UsoAnottations {

    public static void main(String[] args) {

        // 1.- leer el xml de configuracion

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.- pedir un bean a travez de anotaciones al contenedor

        Empleados Antonio = context.getBean("ComercialExperimentadoBean", Empleados.class);

        System.out.println(Antonio.getTareas());
        System.out.println(Antonio.getInformes());

        // vamos  ver otra anotacion importante de Autowired
        // vamos a hacer un ejemplousando de una inyecion de dependiencias con constructor

       // Ahora veremos la defincion del Scope es decir como se inyectaran los objeto usan el patron singleton o prototype


       context.close();


    }
}
