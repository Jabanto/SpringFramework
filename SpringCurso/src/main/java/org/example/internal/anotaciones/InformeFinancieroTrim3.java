package org.example.internal.anotaciones;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim3 implements CreacionInformeFinanciero {

    public String getInformeFinaciero() {
        return "Presentacion de informe favorabloe del trimestre 3";
    }
}
