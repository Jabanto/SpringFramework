package com.javanto.services.calculator.standard;


import com.javanto.services.calculator.Calculator;
import com.javanto.services.calculator.Process;
import org.aspectj.apache.bcel.generic.FieldOrMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

/**
 * Eine Implementierung des einfach Taschenrechners
 * @author javanto
 */
@Service
public class SimpleCalculator implements Calculator{

    private Process process;
    //DI durch Setter
    @Value(value = "5")
    private Integer repetetion;

    public SimpleCalculator(){}

    @Autowired
    public SimpleCalculator( @Qualifier("calculo")Process process){
        this.process = process;
    }

    public Object dataRequest(){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < repetetion; i++) {

            stringBuilder.append(i+1).append(" ").append(process.execute()).append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * Region Setter and Getter
     * kann man auch hier @value einsetzen oder in die Properti
     */

    //@Value(value = "5")
    public void setRepetetion(Integer repetetion){
        this.repetetion = repetetion;
    }


    /**
     * {@inheritDoc}
     * @see Calculator#add(double[])
     *
     */
    @Override
    public double add(double... summands) {
        notNull(summands,"Die Sumannden sind null");

        double result = 0;
        for (double sum : summands) {
            result += sum;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     * @see Calculator#add(int[])
     *
     */
    /**
     * {@inheritDoc}
     * @see Calculator#add(int[])
     */
    @Override
    public int add(int... summands) {

        System.out.println("Wiederholen DataAbfrage: " + dataRequest());
        notNull(summands, "Die Summanden sind null");

        int result = 0;

        for (int sum : summands) {
            result += sum;
        }

        return result;
    }
}
