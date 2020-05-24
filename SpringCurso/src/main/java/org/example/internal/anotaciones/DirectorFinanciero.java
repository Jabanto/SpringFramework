package org.example.internal.anotaciones;




public class DirectorFinanciero implements Empleados {


    private CreacionInformeFinanciero informeFinanciero;

    public DirectorFinanciero(){}

    public DirectorFinanciero(CreacionInformeFinanciero informeFinanciero) {
        this.informeFinanciero = informeFinanciero;
    }

    public String getTareas() {
        return "Gestion y Direccion de las operacion financieraas de la empresa";
    }

    public String getInformes() {
        return informeFinanciero.getInformeFinaciero();
    }



}
