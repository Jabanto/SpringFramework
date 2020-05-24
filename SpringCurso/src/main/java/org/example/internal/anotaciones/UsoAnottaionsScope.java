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

        Empleados Antonio = context.getBean("ComercialExperimentadoBean", Empleados.class);
        Empleados Lucia = context.getBean("ComercialExperimentadoBean", Empleados.class);

        System.out.println(Antonio.getTareas());
        System.out.println(Antonio.getInformes());

        System.out.println(Lucia.getTareas());
        System.out.println(Antonio.getInformes());

        // apunta al mismo objeto a variable en memoria por defecto si ya que el patron es singleton

        if (Antonio==Lucia) {
            System.out.println("Apuntan al mismo lugar en memoria");
            System.out.println(Antonio + "\n" + Lucia);
        }else{
            System.out.println("No aputan al mismo lugar en la memoria");
            System.out.println(Antonio + "\n" + Lucia);
        }

        context.close();
    }

}
