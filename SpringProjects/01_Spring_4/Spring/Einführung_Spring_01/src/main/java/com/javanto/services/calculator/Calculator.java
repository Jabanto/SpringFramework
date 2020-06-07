package com.javanto.services.calculator;


/**
 * Ein Einfach Taschenrechner
 * @author javanto
 */

public interface Calculator {

    /**
     * Addiere die rationalen Zahlen
     * @param summands die Summanden
     * @return die Summe
     */

    double add(double... summands);


    /**
     * Addiere die natürlichen Zahlen.
     * @param summands die Summanden
     * @return die Summe
     */

    int add(int... summands);


}
