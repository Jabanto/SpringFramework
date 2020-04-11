package com.javanto.app;


import com.javanto.services.calculator.Calculator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class Application implements Runnable {

private static final Logger logger = getLogger(Application.class);

@Autowired(required = true)
private Calculator calculator;
    /**
     * { @inheritDoc}
     * @see Runnable#run()
     */
    @Override
    public void run() {

        //Aufruf des Taschenrechners
        double result = calculator.add(1,2,3);
        logger.info("Ergebnis 1 ={}",result);

        result = calculator.add(32.1,4,5.7);
        logger.info("Ergebnis 2 = {}",result);

    }
}
