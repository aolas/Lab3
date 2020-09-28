package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayData;
    TextView getDisplayDataAll;
    Callculator calc = new Callculator();
    String textas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayData = findViewById(R.id.textDisplay);
        this.getDisplayDataAll = findViewById(R.id.textDisplayAll);
    }
    public void onBtn0Click(View view) {
        this.displayData.append(getString(R.string.num0));
    }
    public void onBtn1Click(View view) {
        this.displayData.append(getString(R.string.num1));
    }
    public void onBtn2Click(View view) {
        this.displayData.append(getString(R.string.num2));
    }
    public void onBtn3Click(View view) {
        this.displayData.append(getString(R.string.num3));
    }
    public void onBtn4Click(View view) {
        this.displayData.append(getString(R.string.num4));
    }
    public void onBtn5Click(View view) {
        this.displayData.append(getString(R.string.num5));
    }
    public void onBtn6Click(View view) {
        this.displayData.append(getString(R.string.num6));
    }
    public void onBtn7Click(View view) {
        this.displayData.append(getString(R.string.num7));
    }
    public void onBtn8Click(View view) {
        this.displayData.append(getString(R.string.num8));
    }
    public void onBtn9Click(View view) {
        this.displayData.append(getString(R.string.num9));
    }
    public void onBtnBkspcClick(View view) {
        textas = calc.eraseLastChar(displayData.getText().toString());
        displayData.setText(textas);
    }
    public void onBtnChangeSign(View view) {
        displayData.setText(calc.changeSign(displayData.getText().toString()));
    }
    public void onBtnSum(View view) {
        calc.setFirstVariable(displayData.getText().toString());
        getDisplayDataAll.setText( calc.getDataToDisplay(getString(R.string.plus)) );
    }
}
class Callculator{
    String varFirst;
    String lastOperation;
    void setFirstVariable(String variable){
        if (varFirst != null && varFirst.length() > 0 ){
            sumVariables(variable);
        } else {
            varFirst = variable;
        }

    }
    String getDataToDisplay(String operation){
        return varFirst + operation;
    }
    String getFirsVariable(){
        return varFirst;
    }
    void sumVariables(String seconVar){

        if (varFirst.contains(".") || seconVar.contains(".")){
            varFirst = String.valueOf(Float.parseFloat(varFirst) + Float.parseFloat(seconVar));
        } else {
            varFirst = String.valueOf(Integer.parseInt(varFirst) + Integer.parseInt(seconVar));
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