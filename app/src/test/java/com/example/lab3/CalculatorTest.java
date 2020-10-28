package com.example.lab3;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest extends TestCase {
    Calculator calc = new Calculator();
    String result;

    @Test
    public void testSetVariable() {
        calc.setDefaultStates();
        calc.setVariable("99");
        result = calc.gettVariable();
        assertEquals("99.0", result);
    }
    public void testTestSetVariable() {

    }

    public void testSetOperation() {
        calc.setDefaultStates();
        calc.setVariable(121);
        calc.setOperation("+");
        calc.setVariable("1");
        calc.setOperation("+");
        result = calc.getFirstValue();
        assertEquals("122.0", result);
    }

    public void testCanUseEquual() {
        calc.setDefaultStates();
        calc.setVariable(100);
        assertEquals(false, calc.canUseEquual());
        calc.setOperation("+");
        calc.setVariable("22");
        assertEquals(true, calc.canUseEquual());
    }


    public void testGetSqrt() {
        calc.setDefaultStates();
        calc.setVariable(121);
        result =  calc.getSqrt();
        assertEquals("11.0",result);
    }

    public void testGetCurrentVariable() {
        calc.setDefaultStates();
        calc.setVariable(121);
        calc.setOperation("+");
        calc.setVariable(12);
        result = calc.gettVariable();
        assertEquals("12.0",result);
    }

    public void testGettVariable() {
        calc.setDefaultStates();
        calc.setVariable(121);
        result = calc.gettVariable();
        assertEquals("121.0",result);
    }

    public void testCheckForZero() {
        calc.setDefaultStates();
        assertEquals(true,calc.checkForZero("0"));
        assertEquals(false,calc.checkForZero("5"));
        assertEquals(false,calc.checkForZero("-5"));

    }

    public void testCompleatOperation() {
        calc.setDefaultStates();
        calc.setVariable(12);
        calc.setOperation("-");
        calc.setVariable(12);
        calc.compleatOperation();
        result = calc.gettVariable();
        assertEquals("0.0",result);
    }

    public void testEraseLastChar() {
        calc.setDefaultStates();
        result = calc.eraseLastChar("0.0568");
        assertEquals("0.056",result);
    }

    public void testChangeSign() {
        calc.setDefaultStates();
        result = calc.changeSign("5");
        assertEquals("-5.0",result);
    }

    public void testValidNumber() {
        calc.setDefaultStates();
        assertEquals(false ,calc.validNumber("-"));
        assertEquals(true ,calc.validNumber("1"));
        assertEquals(true ,calc.validNumber("0."));
        assertEquals(true ,calc.validNumber("-0."));
        assertEquals(true ,calc.validNumber("0"));
    }

    public void testGetSq() {
        calc.setDefaultStates();
        calc.setVariable(11);
        assertEquals("121.0" ,calc.getSq());
        calc.setVariable(-10);
        assertEquals("100.0" ,calc.getSq());
    }

    public void testCheckIfPositiveNumber() {
        calc.setDefaultStates();
        calc.setVariable(-10);
        assertEquals(false, calc.checkIfPositiveNumber());
        calc.setVariable(10);
        assertEquals(true, calc.checkIfPositiveNumber());
        calc.setVariable(0);
        assertEquals(true, calc.checkIfPositiveNumber());
    }

    public void testOneOverX() {
        calc.setDefaultStates();
        calc.setVariable(4);
        calc.oneOverX();
        result = calc.gettVariable();
        assertEquals("0.25", result);
    }

    public void testCheckIfDotExist() {
        assertEquals(true, calc.checkIfDotExist("0.5"));
        assertEquals(false, calc.checkIfDotExist("5"));
        assertEquals(true, calc.checkIfDotExist("0.5354"));
    }

    public void testDivisionByZeroOnEqual() {
        calc.setDefaultStates();
        calc.setVariable(1);
        calc.setOperation("/");
        calc.setVariable(0);
        assertEquals(true, calc.divisionByZeroOnEqual());
        calc.setVariable(5);
        assertEquals(false, calc.divisionByZeroOnEqual());
    }
}