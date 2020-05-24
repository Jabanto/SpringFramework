package org.example.internal.anotaciones;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.SortedMap;

public class UsoAnottaionsScope {

    public static void main(String[] args) {

        // 1.- leer el xml de configuracion

        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 1b.- vamos a leer la configuracion definida con java object y anotaciones

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmpleadosConfig.class);

        //2.- pedir un bean a travez de anotaciones al contenedor

        Empleados empleados = context.getBean("directorFinanciero", Empleados.class);

        System.out.println(empleados.getInformes());
        System.out.println(empleados.getTareas());

        // como pedir beans a container de spring utilizando java y prescindiendo del archivo xml
        // vamos crear una clase que sea capas de crear informe finnacieros

        context.close();
    }

}
