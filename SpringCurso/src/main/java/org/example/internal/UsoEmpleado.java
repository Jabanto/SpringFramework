package org.example.internal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleado {

    public static void  main(String[] args){

        // Cracion standar de archivos en java
        //creacion de objetos tipo jefe empleado

        //Empleados empleado1JE = new DirectorEmpleado();

        //uso de los objetos creados

        //System.out.println(empleado1JE.getTareas());

        // Usar Sporing con XML
        //1 Usar el contexto de Spring

        ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2 pedir al contexto el bean que hemos definido de en applicationContext xml

        DirectorEmpleado juan = contexto.getBean("miEmpleadoBean", DirectorEmpleado.class);

        // Utilizar el bean aqui se cargara el metodo get Tareas del tipo director empleado o el que hallamos defindo en el Bean
        // pero por ahor solo los metodoos y campos que hayamos definido en la interfaz empleado

        System.out.println(juan.getTareas());

        // aqui hemos inyectado campos en la clase directro empleado y sus valores los hemos definido en un archivo externo properties
        // ya que es mas facil de editar e intuitivo que el xml file
        System.out.println(juan.getEmail());
        System.out.println(juan.getNombreEmpresa());

        //una vez utilizado el bean , para aprovechar recursos cerramos el context
        //contexto.close();


        /** Ahora vamos usar el concep de inyecion de dependencias  utilzando la inyeccion en constructor y mediante un setter
         *
         * Para que nuestro objetos puedan crear informe
         */

        // Primer fase , crear la Classe e interfaz de la dependencia en este caso clase Informe que se inyectara en objetos
        // Segundo, Creacion de constructor  en la clase que usara el informe para la inyeccion de dependencias
        // Configurar la inyeccion de dependencia en el archivo applicationcontext

        System.out.println("(info) Inyectamos un bean de la clase informe des el constructor e el bean de la clase que reciba esa dependencialanza el informe");
        System.out.println(juan.getInforme());


        //ahora haremos una inyecion pero desde el setter , vamos a repetir los pasos de antes pero cambiaremos basicamento lo que contiene
        // el archivo application context

       SecretarioEmpleado Maria = contexto.getBean("miSecretarioBean", SecretarioEmpleado.class);

        System.out.println(Maria.getTareas());
        System.out.println(Maria.getInforme());


        // Aqui vamos  a utilizar los campos que hemos inyectado en la clasesecretario empleado y configurado en el archivo xml

        System.out.println( "Email: " + Maria.getEmail());
        System.out.println(Maria.getNombreEmpresa());

        // ahoa hablaremos de los tipo de objetos que genera en context de spring
        // el singleton y prototype

       // Ahora vamos a ver unos ejemplos de singleton y prototype

        contexto.close();


    }

}
