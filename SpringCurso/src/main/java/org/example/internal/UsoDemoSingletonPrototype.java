package org.example.internal;

import org.omg.CORBA.PERSIST_STORE;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoDemoSingletonPrototype {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        //  ejemplos de single ton y prototype
        // peticion de beans al contenedor de tipo secretario empleado

        SecretarioEmpleado Maria = context.getBean("miSecretarioBean", SecretarioEmpleado.class);
        SecretarioEmpleado Pedro = context.getBean("miSecretarioBean", SecretarioEmpleado.class);
        SecretarioEmpleado Manolo = context.getBean("miSecretarioBean", SecretarioEmpleado.class);

        // los dos son single por defecto y aputan a las misma direcion en memoria ya que trabamos sobre patron singleton
        System.out.println(Maria);

        System.out.println(Pedro);
        System.out.println(Manolo);
        // pero si cambimos a prototype el flujo de tabajo cambiaria a else
        if (Maria==Pedro) System.out.println("Apuntan al mismo objeto");
        else System.out.println("No se trata del mismo objeto");

    }

}
