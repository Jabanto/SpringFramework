package org.example.internal.anotaciones;
import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim1 implements CreacionInformeFinanciero {

    public String getInformeFinaciero() {
        return "Presentacion del informe finaciero del trimestre 1";
    }
}
