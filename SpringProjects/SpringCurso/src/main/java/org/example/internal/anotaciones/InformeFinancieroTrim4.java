package org.example.internal.anotaciones;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim4 implements CreacionInformeFinanciero {

    public String getInformeFinaciero() {
        return "Presentacion del informe financiero anual";
    }
}
