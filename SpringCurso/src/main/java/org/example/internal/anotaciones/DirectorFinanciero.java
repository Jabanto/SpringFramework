package org.example.internal.anotaciones;


import org.springframework.beans.factory.annotation.Value;

public class DirectorFinanciero implements Empleados {


    private CreacionInformeFinanciero informeFinanciero;
    //Aqui inyectamos los campos y los valores que hemos definido en el archivo properties
    // para inyectar los valores usamos la anotacion Value
    @Value("${email}")
    private String email;

    @Value("${nombreEmpresa}")
    private String nombreEmpresa;

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

    public String getEmail() {
        return email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

}
