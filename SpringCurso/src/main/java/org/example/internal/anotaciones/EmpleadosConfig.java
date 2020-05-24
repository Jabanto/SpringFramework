package org.example.internal.anotaciones;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// aqui hacemos los mismo que en archivo xml esto suytituye ese archivo
// tenemos que definir Componet scan para que spring sepa donde escanear cuando se use autowired
@Configuration
@ComponentScan("org.example.internal.anotaciones")
public class EmpleadosConfig {

    //definir elbean para el informe FinancieroDtoCompras
    
    // aqui hacemos lo mimo que haciemos con el xml pero a travez de beans , tambin podria hacer utilizando autowired y component
    @Bean
    public CreacionInformeFinanciero informeFinancieroDtoCompras(){
        return new InformeFinancieroDtoCompras();
    }

    // definerel bean para DirectorFinanciero e inyectar dependencia en este caso el bean que cabamosde crear informeFinancieroDtoCompras

    @Bean
    public Empleados directorFinanciero(){
        return new DirectorFinanciero(informeFinancieroDtoCompras());
    }

}
