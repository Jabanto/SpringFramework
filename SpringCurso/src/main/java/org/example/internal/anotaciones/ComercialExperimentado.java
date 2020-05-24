package org.example.internal.anotaciones;


import org.springframework.stereotype.Component;

//Con conponen yxa tenemosdefinido nuestro bean , el nombre entre comilla seria el id
@Component("ComercialExperimentadoBean")
public class ComercialExperimentado implements Empleados {

    public String getTareas() {
        return "Vender ,vender y vender mas";
    }

    public String getInformes() {
        return "Informes generado por el comercial ";
    }
}
