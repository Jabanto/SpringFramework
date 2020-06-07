package org.example.internal.xml;

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



        // Ahora hablaremos del ciclo de vida de los Beans en contenedorde Spring
        // para saber como realizar tareas antes de la creacion y despues de usar el bean
        // pero antes veamos cual es el ciclo de vida del bean

        //1 se pone en funcionamient op el contenedor
        //2 se crea los beans, o una instancia
        //3 se inyectan la dependencias definidas
        // 4 internamente el contenedor procesa el bean
        // 5 una vez procesado esta listo para su uso , durante la vida del contenedor
        // 6 se apga el contededor

        // Este el ciclo de vida general pero aveces podemos necesitar realizar tareas antes de lacreacion del bean
        // para esto tenemos los metods init() y destroy() como por ejemplo cargar dependecia de otro beans
        // o para la activacion retarda de otro servicios como sockets o conexcion a base de datos
        // lo mismo par el metodo destroy cuando el bean este ya destruido cerrar socket o conexcion para optimizar el programa
        // vamos a ver



        // Ahora vamos a ver Spring con las javaAnotations
        // Las anotaciones sirve para agregar metadatos a nuestros programa java
        //  los metadatos describen el contenido y el porposito de un objeto, es decir por ejemplo no permiter prescindir de la
        // los archivos xml en este caso seguiremo usando el archivo xml pero simplificaremos su contenido


        // Spring como trabaja con la annotaciones
        // Spring scanea nuestro codigo en busca de estas anotaciones , este concepto se le conoce como recursividad
        // para esto tenemos que preparar el xml para que spring busque o escanee las anotaciones
        // para simplificar nuestra creacion de beans y inyeccion de dependencias
        // estas no ayudan sober todo cuando nuestro proyecto tienes muchos beans o dependencias

        /**
         * Vamos a ver que pasos a seguir para utilizar la annotations en spring
         *
         * 1.- Preparar el xml para que spring pueda escanear el codigo
         *
         * 2.- Agregaar las anotaciones en codigo
         *
         * 3.- Pedir /utilizar el bean definido con anotaciones
         *
         */







        contexto.close();


    }

}
