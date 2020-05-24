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

        // Los pasos #
        /**
         * 1.- Crear la clase + interfaz a inyectar (dependecias)
         *
         * 2.- Crear el constructor para inyecion en la clase que lo solicite o necite la dependencia
         *
         * 3.- Configurar la dependencia con el Autowired , escribirlo en la clase donde seinyectara la dependencia
         */



    }
}
