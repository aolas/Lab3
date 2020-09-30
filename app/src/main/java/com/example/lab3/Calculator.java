package com.example.lab3;

public class Calculator{
    float varFirst, varSecond;
    boolean stateSecond = false;
    String lastOperation;
    void setDefaultStates(){
        stateSecond = false;
        varFirst = 0;
        varSecond = 0;
        lastOperation="";
    }
    void setVariable(String variable){
        if (stateSecond == false){
            varFirst = Float.parseFloat(variable);
        } else {
            varSecond = Float.parseFloat(variable);
        }
    }
    boolean setOperation(String operation){
            if (stateSecond == false){
                lastOperation = operation;
                stateSecond = true;
            } else {
                compleatOperation();
                lastOperation = operation;
                stateSecond=true;
            }
            return true;
    }
    String getSqrt(String data){
        String currentValue;
        //stateSecond = false;
        currentValue = String.valueOf(Math.sqrt(Float.parseFloat(data)));
        setVariable(currentValue);
        return currentValue;
    }
    String getDataToDisplay(String operation){
        return varFirst + operation;
    }
    String getFirsVariable(){
        return String.valueOf(varFirst);
    }
    public boolean checkForZero(String currentNumber){
        float numberF;
        if (currentNumber != null && currentNumber.length() > 0 ){
            numberF = Float.parseFloat(currentNumber);
            if (numberF == 0) {
                return true;
            }else{
                return false;
            }
        } else{
            return false;
        }

    }
    public void compleatOperation(){
        if (stateSecond == true){
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
        if (data != null && data.length() > 0 ) {
            data = data.substring(0, data.length() - 1);
            setVariable(data);
        }
        return data;
    }
    public String changeSign(String data){
        float numberF;
        int numberI;
        if (data.contains(".")){
            numberF = Float.parseFloat(data) * -1;
            return String.valueOf(numberF);
        } else{
            numberI = Integer.parseInt(data) * -1;
            return String.valueOf(numberI);
        }
    }

    public String getSq(String input) {
        String currentValue;
        float numberF;
        numberF = Float.parseFloat(input);
        numberF *= numberF;
        currentValue = String.valueOf(numberF);
        setVariable(currentValue);
        return  currentValue;
    }
    public boolean checkIfPositiveNumber(String input){
        float numberF = Float.parseFloat(input);
        return numberF >= 0;
    }

    public String oneOverX(String toString) {
        String number = String.valueOf(1 / Float.parseFloat(toString));
        setVariable(number);
        return number;
    }

}
