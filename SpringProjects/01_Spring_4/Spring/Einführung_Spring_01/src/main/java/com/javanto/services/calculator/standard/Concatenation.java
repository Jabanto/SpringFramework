package com.javanto.services.calculator.standard;

import com.javanto.services.calculator.Process;
import org.springframework.stereotype.Service;

@Service
public class Concatenation implements Process {

    @Override
    public Object execute() {
        //Strign erzeugen um String hola und mundo addieren
        return new StringBuilder().append("Hola").append(" mundo");
    }
}
