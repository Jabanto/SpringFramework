package org.example.internal.anotaciones;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// aqui hacemos los mismo que en archivo xml esto suytituye ese archivo
@Configuration
@ComponentScan("org.example.internal.anotaciones")
public class EmpleadosConfig {
    

}
