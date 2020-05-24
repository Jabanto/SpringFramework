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

        // ahora vamos a utilizar los metodos init() y destroy()
        // en este caso sin  el archivo de configuracion sino utilizando las anotaciones
        // recordar el ciclo de vidad de los beans en el spring container
        // 1 Contenedor 2 creacion de Bean , 3 inyeccion de dependias , 4 procesado de Bean 5 metodo ini(),
        // 6 Bean listo para su uso 7 cerrar contenedor 8 utilizar netodo destroy()
        // esta anotaciones sera las PostContruct y PreDestroy
       context.close();


    }
}
