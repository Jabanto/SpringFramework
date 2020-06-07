package org.example.internal.xml;

public class JefeEmpleado implements Empleados {

    private CreacionInformes nuevoInforme;

    public JefeEmpleado(CreacionInformes nuevoInforme) {
        this.nuevoInforme = nuevoInforme;
    }

    //sobreescribimos el metodo de la interface
    public String getTareas(){
        return  "Gestiono las cuestiones relativas a mis empleados de seccion";
    }

    public String getInforme() {
        return "Informe presentado por el jefe con retificaciones: " + nuevoInforme.getInforme();
    }
}
