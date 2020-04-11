package com.javanto.services.calculator.standard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test der Klasse {@link SimpleCalculator}
 * @author jabanto
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SimpleCalculatorTest {

    @Autowired
    private SimpleCalculator calculator;
    /**
     * Test method for {@link SimpleCalculator#add(double[])}
     */
    @Test
    public void testAddDoubleArray() {
        double result = calculator.add(1.0,2.0);
        assertThat("Test der Addition", result, is(4.0));
    }

    /**
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddIntArray() {
        calculator.add((int[])null);
    }
}