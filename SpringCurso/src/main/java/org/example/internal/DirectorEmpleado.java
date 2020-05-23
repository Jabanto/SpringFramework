package org.example.internal;

public class DirectorEmpleado implements Empleados {

    //Creacion del campo ti creacionInforme(interfaz)
    private CreacionInformes informeNuevo;

    private  String email;
    private  String nombreEmpresa;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    // aqui se inyecta la dependencia
    public DirectorEmpleado(CreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }

    public String getTareas() {
        return "Gestionar la plantilla de la empresa";
    }

    public String getInforme() {
        return "Informe creado por el director: " + informeNuevo.getInforme();
    }
}
