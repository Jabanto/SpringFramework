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


    // como crear metodo init  ejecutar tareas antes del qeu el beane ste disponible
    // suelen servoid pero puede retornar un valor , el nombre puede ser init pero no tiene porque
    public void metodoInicial(){

        System.out.println("Dentro del metodo init(), las tareas de ejecutar antes de que el bean este listo para usar");

    }


    // como crear metodo destroy cuando el bean haya sido utilizado

    public void metodoFinal(){
        System.out.println("Dentro del metodo Destroy() , aqui se ejecutaran las tareas despues de utilizar el bean");
    }


}
