package org.example.internal.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoCicloVidaBean {

    public static void main(String[] args) {

        // cargar el contexto de spring definido en xml

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

        Empleados juan = context.getBean("miEmpleadoBean", Empleados.class);
        System.out.println(juan.getInforme());

        context.close();

    }
}
