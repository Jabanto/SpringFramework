package org.example.internal.anotaciones;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim2 implements CreacionInformeFinanciero {


    public String getInformeFinaciero() {
        return "Presentacion de informe catastrofico del trimestre 2";
    }
}
