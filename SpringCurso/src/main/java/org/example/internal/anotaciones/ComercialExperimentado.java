package org.example.internal.anotaciones;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Con conponen yxa tenemosdefinido nuestro bean , el nombre entre comilla seria el id
// se puede precindir el id name en este caso ComercialExperimentado, spring utiliza como formato entonces la primera letro como minusculas
// aqui el id automatico seria comercialExperimentado , con la c minuscula en el caso que no pongamos id en comporent()
@Component("ComercialExperimentadoBean")
public class ComercialExperimentado implements Empleados {

    private CreacionInformeFinanciero nuevoInforme;

    // Si ponemos aqui autowired , spring bucas en todos el proyecto una clase que implemete la interfaz creacioninformeFinaciero
    // En este caso InformeFinacieroTrim1 y cuado la emcuentra la inyecta como dependencia , asiq como definiamos en el xml
    // En algunas versiones  apartir de la 4.3 de Spring no es necesario escribirla para inyectar la dependencia si solo tenemos un constructor
    // como en este caso si hubiera otro constructor la anotacion seria necesaria
    @Autowired
    public ComercialExperimentado(CreacionInformeFinanciero nuevoInforme) {

        this.nuevoInforme = nuevoInforme;
    }

    public String getTareas() {
        return "Vender ,vender y vender mas";
    }

    public String getInformes() {

        // aqui llamanos al metod de la interfaz Ceacion informefiunacieron
        return nuevoInforme.getInformeFinaciero();
    }
}
