package org.example.internal.xml;

public class SecretarioEmpleado implements Empleados {



    private CreacionInformes informeNuevo;
    // Vamos a inyectar dependencias de tipo campo o propiedades en nuestro caso email y nombre empresa
    // vamos a crear la inyeccion desde el config file, pero aqui necedsitamos los campos y sus metodos getter y setter
    private  String email;
    private  String nombreEmpresa;



    public String getTareas() {
        return "Gestionar la agenda de los jefes";
    }

    public String getInforme() {
        return "Informe generado por el secretario: "  + informeNuevo.getInforme();
    }

    //Region Getter Setter

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

    //Metodo Setter donde se aplica la inyeccion de dependencia
    public void setInformeNuevo(CreacionInformes informeNuevo) {
        this.informeNuevo = informeNuevo;
    }

}
