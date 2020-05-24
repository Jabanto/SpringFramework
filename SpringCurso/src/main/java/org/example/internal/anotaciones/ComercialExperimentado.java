package org.example.internal.anotaciones;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Con conponen yxa tenemosdefinido nuestro bean , el nombre entre comilla seria el id
// se puede precindir el id name en este caso ComercialExperimentado, spring utiliza como formato entonces la primera letro como minusculas
// aqui el id automatico seria comercialExperimentado , con la c minuscula en el caso que no pongamos id en comporent()
@Component("ComercialExperimentadoBean")
public class ComercialExperimentado implements Empleados {


    // podemos usar autowired directament en en campo sin usar o definir el autowired (utilizando el concepto de reflexion)
    // funcinaral la inyecion sin agregar el settter o constructor
    // el nombre del metod es irrelevanto
    // el metodo a usar sera siempre de acuerdo a facilitar el codigo , segun tu criterio y logica
    // es decir donde hay mucho setter o muchos constructores mejor usar inyecion directa des el campo y manteniedo el estilo en la otra clase
    // utilizando qualifier decimos a autowired que bean en concreto queremos usar en elcaso que tengamos mas clase que implemente em la mis interfaz
    @Autowired
    @Qualifier("informeFinancieroTrim4")
    private CreacionInformeFinanciero nuevoInforme;


    public ComercialExperimentado(){

    }

    // Si ponemos aqui autowired , spring bucas en todos el proyecto una clase que implemete la interfaz creacioninformeFinaciero
    // En este caso InformeFinacieroTrim1 y cuado la emcuentra la inyecta como dependencia , asiq como definiamos en el xml
    // En algunas versiones  apartir de la 4.3 de Spring no es necesario escribirla para inyectar la dependencia si solo tenemos un constructor
    // como en este caso si hubiera otro constructor la anotacion seria necesaria
    /*@Autowired
    public ComercialExperimentado(CreacionInformeFinanciero nuevoInforme) {

        this.nuevoInforme = nuevoInforme;
    }*/

    public CreacionInformeFinanciero getNuevoInforme() {
        return nuevoInforme;
    }

    /*@Autowired
    public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
        this.nuevoInforme = nuevoInforme;
    }*/

    public String getTareas() {
        return "Vender ,vender y vender mas";
    }

    public String getInformes() {

        // aqui llamanos al metod de la interfaz Ceacion informefiunacieron
        return nuevoInforme.getInformeFinaciero();
    }
}
