package SoundSystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JAbanto on 10.05.2017.
 *
 * escribimos una configuracion explicita  para indicar a Spring que busque de forma predeterminada
 * las clases anotadao con Component y que cree bean para ellas . la clase de Configuracion del siguiente listado
 * muestra la configuracion minima necesario pra conseguirlo
 */

/*
Sin configuracion adicional componentscan analaiza de forma predeterminadad el mismo paquete de la clase configurarion por ello como CDPlayerConfig pertenece al paquete SoundSystem, Spring examina dicho paquete y todos sus pauqetes secundarios en busca de clase anotadas con @ component x crear el Bean lo mismo
podira hacer explicitamente mediante configuracion XML
 */

@Configuration
/*
tambien como en component podemos definier los pquetes por donde Componentscan
buscara los component pra crear los bean determinaddos simplement utilizando
ComponentScan("nombre del paquete")
 */

/*
al utlizar basesPackageClasses Spring buiscara en el Package donde esta clase se encuentre
es decir analizaras no solo esta clase sino las que esten en su mismo paquete ,
podemos utilizar basePackage="nombre del paquete" , pero talvez cuando refactorizemos
talvez no seas seguro por eso basePackagesClasse podria ser mas seguro

 */

@ComponentScan(basePackageClasses = SgtPeppers.class)
public class CDPlayersConfig {


    /*
     esta clase defina un especificacion de conexcion de Spring , expresada en java . En un apartado posterior
     veremos en mayor detalle la configuration de Spring
     basada en Java. Pro el momneto fijese en que CDPlayerConfig no define explicitamente
     ningun bean sino que se anora con @ComponenteScan pra habilitar el analisis de componentes de Spring dentro
     de la aplicacion

     */
}
