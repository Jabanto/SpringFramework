package org.example.internal.anotaciones;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.SortedMap;

public class UsoAnottaionsScope {

    public static void main(String[] args) {

        // 1.- leer el xml de configuracion

        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 1b.- vamos a leer la configuracion definida con java object y anotaciones

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmpleadosConfig.class);

        //2.- pedir un bean a travez de anotaciones al contenedor usando codigo Java

        //Empleados empleados = context.getBean("directorFinanciero", Empleados.class);

        DirectorFinanciero empleados = context.getBean("directorFinanciero", DirectorFinanciero.class);

        System.out.println(empleados.getInformes());
        System.out.println(empleados.getTareas());
        System.out.println("Email del director: " +  empleados.getEmail());
        System.out.println("Nombre de la empresa: " + empleados.getNombreEmpresa());

        // como pedir beans a container de spring utilizando java y prescindiendo del archivo xml
        // vamos crear una clase que sea capas de crear informe finnacieros


        // vamos a ver como utilizar  ingresar valores a nuetrso beans o campos y tambion usar archivos externos
        // como en este caso log4j.properties
        // Esto ya lo vimos antes usando xml pero ahora usaremos las anotaciones en java

        context.close();
    }

}
