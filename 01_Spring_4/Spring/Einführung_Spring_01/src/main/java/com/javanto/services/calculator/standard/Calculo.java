package com.javanto.services.calculator.standard;

import com.javanto.services.calculator.Process;
import org.springframework.stereotype.Service;

@Service
public class Calculo implements Process {

    @Override
    public Object execute() {
        return (int)(Math.random()*100.0);
    }

}
