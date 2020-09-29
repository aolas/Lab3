package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displayData;
    TextView getDisplayDataAll;
    Callculator calc = new Callculator();
    String textas;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayData = findViewById(R.id.textDisplay);
        this.getDisplayDataAll = findViewById(R.id.textDisplayAll);
        toast =Toast.makeText(getApplicationContext(),R.string.empty,Toast.LENGTH_SHORT);
        toast.setMargin(50,50);
    }
    public void onClearClick(View view) {
        calc.setDefaultStates();
        displayData.setText("0");
        getDisplayDataAll.setText("");
    }
    public void onBtn0Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num0));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn1Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num1));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn2Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num2));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn3Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num3));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn4Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num4));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn5Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num5));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn6Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num6));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn7Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num7));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn8Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num8));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtn9Click(View view) {
        displayData.setText(calc.checkForZero(displayData.getText().toString()));
        this.displayData.append(getString(R.string.num9));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtnBkspcClick(View view) {
        textas = calc.eraseLastChar(displayData.getText().toString());
        displayData.setText(textas);

    }
    public void onBtnChangeSign(View view) {
        displayData.setText(calc.changeSign(displayData.getText().toString()));
        calc.setVarable(displayData.getText().toString());
    }
    public void onBtnSum(View view) {
        //calc.setFirstVariable(displayData.getText().toString(), getString(R.string.plus));
        //getDisplayDataAll.setText( calc.getDataToDisplay(getString(R.string.plus)) );
        //displayData.setText("");
        calc.setOperation(getString(R.string.plus));
        getDisplayDataAll.setText( calc.getDataToDisplay(getString(R.string.plus)) );
        displayData.setText("");
    }
    public void onMinusClick(View view){
        calc.setOperation(getString(R.string.minus));
        getDisplayDataAll.setText( calc.getDataToDisplay(getString(R.string.minus)) );
        displayData.setText("");

    }
    public void onMultiplyClick(View view){
        calc.setOperation(getString(R.string.multiply));
        getDisplayDataAll.setText( calc.getDataToDisplay(getString(R.string.multiply)) );
        displayData.setText("");
    }
    public void onDivisionClick(View view){
        calc.setOperation(getString(R.string.div));
        getDisplayDataAll.setText( calc.getDataToDisplay(getString(R.string.div)) );
        displayData.setText("");
    }

    public void onEqualClick(View view){
        calc.setVarable(displayData.getText().toString());
        calc.compleatOperation();
        displayData.setText(calc.getFirsVariable());
        getDisplayDataAll.setText("");
        //calc.compleatOperation(displayData.getText().toString());
        //displayData.setText(calc.getFirsVariable());
        //getDisplayDataAll.setText("");
        //calc.setFirstVariable();
        toast.show();
    }

}
class Callculator{
    String varFirst, varSecond;
    boolean stateSecond = false;
    String lastOperation;
    void setDefaultStates(){
        stateSecond = false;
        varFirst = "";
        varSecond = "";
        lastOperation="";
    }
    void setVarable(String variable){
            if (stateSecond == false){
                varFirst = variable;
            } else {
                varSecond = variable;
            }
    }
    boolean setOperation(String operation){
        if ( varFirst != null && varFirst.length() > 0){
            if (stateSecond == false){
                lastOperation = operation;
                stateSecond = true;
            } else{
                if (lastOperation.compareTo("+") == 0) {
                    sumVariables();
                } else if (lastOperation.compareTo("-") == 0) {
                    diferenceVariables();
                } else if (lastOperation.compareTo("*") == 0) {
                    multiplyVariables();
                } else if (lastOperation.compareTo("/") == 0) {
                    divideVariables();
                }

            }

            return true;
        } else {
            return false;
        }
    }
    /*
    void setFirstVariable(String variable,String opeation){
        if ( varFirst != null && varFirst.length() > 0){
            if (opeation.compareTo("+") == 0){
                sumVariables(variable);
            } else if (opeation.compareTo("-") == 0){
                diferenceVariables(variable);
            } else if (opeation.compareTo("*") == 0){
                multiplyVariables(variable);
            } else if (opeation.compareTo("/") == 0){
                divisionVariables(variable);
            }
            lastOperation = opeation;

        } else {
            varFirst = variable;
        }
    }*/
    String getDataToDisplay(String operation){
        return varFirst + operation;
    }
    String getFirsVariable(){
        return varFirst;
    }
    void setFirstVariable(){
        varFirst = "";
        lastOperation="";
    }
    String checkForZero(String currentNumber){
        if (currentNumber.compareTo("0") == 0){
            return "";
        }
        else {
            return currentNumber;
        }

    }
    void compleatOperation(){
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
    void sumVariables(){
        if (varFirst.contains(".") || varSecond.contains(".")){
            varFirst = String.valueOf(Float.parseFloat(varFirst) + Float.parseFloat(varSecond));
        } else {
            varFirst = String.valueOf(Integer.parseInt(varFirst) + Integer.parseInt(varSecond));
        }
    }
    void diferenceVariables(){
        if (varFirst.contains(".") || varSecond.contains(".")){
            varFirst = String.valueOf(Float.parseFloat(varFirst) - Float.parseFloat(varSecond));
        } else {
            varFirst = String.valueOf(Integer.parseInt(varFirst) - Integer.parseInt(varSecond));
        }
    }
    void multiplyVariables(){
        if (varFirst.contains(".") || varSecond.contains(".")){
            varFirst = String.valueOf(Float.parseFloat(varFirst) * Float.parseFloat(varSecond));
        } else {
            varFirst = String.valueOf(Integer.parseInt(varFirst) * Integer.parseInt(varSecond));
        }
    }
    void divideVariables(){
        if (varFirst.contains(".") || varSecond.contains(".")){
            varFirst = String.valueOf(Float.parseFloat(varFirst) / Float.parseFloat(varSecond));
        } else {
            varFirst = String.valueOf(Integer.parseInt(varFirst) / Integer.parseInt(varSecond));
        }
    }
    String eraseLastChar(String data){
        if (data != null && data.length() > 0 ) {
            data = data.substring(0, data.length() - 1);
        }
        return data;
    }
    String changeSign(String data){
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
}