package com.example.lab3;

public class Calculator{
    private float varFirst, varSecond;
    private boolean stateSecond = false, useEqual = false, operationAdded = false, addPoint = false;
    private String lastOperation="";
    void setDefaultStates(){
        stateSecond = false;
        operationAdded = false;
        useEqual=false;
        varFirst = 0;
        varSecond = 0;
        lastOperation="";
    }
    void setVariable(String variable){
        if (!stateSecond){

            varFirst = Float.parseFloat(variable);

        } else {
            varSecond = Float.parseFloat(variable);
            useEqual = true;
        }
        operationAdded = false;
    }

    void setVariable(float variable){
        if (!stateSecond){
            varFirst = variable;
        } else {
            varSecond = variable;
            useEqual = true;
        }
        operationAdded = false;
    }
    String setOperation(String operation){
            if (!stateSecond || operationAdded){
                lastOperation = operation;
                stateSecond = true;
                operationAdded = true;
            } else {
                compleatOperation();
                lastOperation = operation;
                stateSecond=true;
            }
            useEqual = false;
            return varFirst + operation;
    }
    boolean canUseEquual(){
        return !divisionByZeroOnEqual() && useEqual;
    }
    String getSqrt(){
        setVariable((float) Math.sqrt(getCurrentVariable()));
        return gettVariable();
    }
    float getCurrentVariable(){
        if (stateSecond){
            return varSecond;
        } else{
            return varFirst;
        }
    }
    String gettVariable(){
        if (stateSecond){
            return String.valueOf(varSecond);
        } else {
            return String.valueOf(varFirst);
        }

    }
    public boolean checkForZero(String input){
        if (validNumber(input) ){
            return (getCurrentVariable() == 0) && !input.contains(".");
        } else{
            return false;
        }

    }
    public void compleatOperation(){
        if (stateSecond){
            if (lastOperation.compareTo("+") == 0) {
                sumVariables();
            } else if (lastOperation.compareTo("-") == 0) {
                diferenceVariables();
            } else if (lastOperation.compareTo("*") == 0) {
                multiplyVariables();
            } else if (lastOperation.compareTo("/") == 0) {
                divideVariables();
            }
            stateSecond=false;
        }

    }
    private void sumVariables(){
        varFirst = varFirst + varSecond;

    }
    private void diferenceVariables(){
        varFirst = varFirst - varSecond;

    }
    private void multiplyVariables(){
        varFirst = varFirst * varSecond;
    }
    private void divideVariables(){
        varFirst = varFirst / varSecond;

    }
    public String eraseLastChar(String data){
        if (validNumber(data)) {
            data = data.substring(0, data.length() - 1);
            if(!validNumber(data)) {
                setVariable(0);
                return "0";
            }
        }
        return data;
    }

    public String changeSign(String data){
        float numberF;
        if (validNumber(data)){
            numberF = getCurrentVariable() * -1;
            setVariable(numberF);
            return String.valueOf(numberF);
        }else{
            return "0";
        }
    }
    public boolean validNumber(String input){
        float number;
        if (input != null && input.length() > 0 ){
            try {
                number = Float.parseFloat(input);
                setVariable(number);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }else{
            return false;
        }

    }
    public String getSq() {
        float numberF;
        numberF = getCurrentVariable();
        numberF *= numberF;
        setVariable(numberF);
        return gettVariable();
    }
    public boolean checkIfPositiveNumber(){
        float numberF = getCurrentVariable();
        return numberF >= 0;
    }

    public void oneOverX() {
        float numberF = 1 / getCurrentVariable();
        setVariable(numberF);
    }

    public boolean checkIfDotExist(String data) {
        return data.contains(".");
    }
    public boolean divisionByZeroOnEqual(){
        return lastOperation.contains("/") && varSecond == 0;
    }
}
