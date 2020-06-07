package SoundSystem; /**
 * Created by JAbanto on 10.05.2017.
 */

/**
 *  En Spring los objetos no son los responsables de encontrar o crear el restp de objetos que necesitan prar llevar a cabo su trabajo . en su lugar el contenedor les asigna referencias a los objetos con los que tiene que colaborar . Un componenten de admministracion de pedidos , por ejem,plo puede neceistat un autorizador de tarjetas de credito , pero no tine que crearlo solo tiene que mostarase y recibir el autorizador que necesitat para llevar a cabo su trabajo
 *
 *
 *
 *  las acccions de crear estas associaciones entre objetos de aplicacion es la escencia de la inyeccion de dependencias (DI) y se denomina, de manera habitual , conexcion .
 *
 *  hay varias formas de conectar Beanas nos centraremos en tres enfoques de configuracion
 *
 *   CONFIGURACION EXPLICITA EN XML
 *   CONFIGURACION EXPLICITA DE JAVA
 *   DETECCION IMPLICITA Y CONEXION AUTOMATICA DE BEAN
 *
 */
public class Main {

    /*
    NOS CENTRAREMOS EN LA DETECCION IMPLICITA Y CONEXION AUTOMATICA DE BEANS

    TODAS LAS CLASES BAJO EL PAQUETE SUNDSYSTEM ANOTADAS CON @COMPONENT TAMBIEN SE CREARAN COMO BEAN
    ESA ES LA IMPORATACION DE COMPONENTESCAN


     */



}
