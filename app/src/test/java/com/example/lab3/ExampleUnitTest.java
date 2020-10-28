package com.example.lab3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testCalculatorLogic(){
        Calculator calc = new Calculator();
        String result;
        calc.setDefaultStates();
        calc.setVariable("99");
        calc.setOperation("+");
        calc.setVariable("2");
        calc.compleatOperation();
        result = calc.gettVariable();
        assertEquals("101.0", result);
    }
}