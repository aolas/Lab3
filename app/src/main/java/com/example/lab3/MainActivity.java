package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView displayData;
    TextView getDisplayDataAll;
    Calculator calc = new Calculator();

    String textas;
    Toast message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayData = findViewById(R.id.textDisplay);
        this.getDisplayDataAll = findViewById(R.id.textDisplayAll);
        message =Toast.makeText(getApplicationContext(),"msg",Toast.LENGTH_SHORT);
        message.setGravity(Gravity.CENTER_VERTICAL&Gravity.CENTER_HORIZONTAL,0,0);
        //message.setMargin(50,50);
    }
    public void onClearClick(View view) {
        calc.setDefaultStates();
        displayData.setText("0");
        getDisplayDataAll.setText("");
    }
    public void onBtn0Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num0));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn1Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num1));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn2Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num2));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn3Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num3));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn4Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num4));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn5Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num5));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn6Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num6));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn7Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num7));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn8Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }   
        this.displayData.append(getString(R.string.num8));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtn9Click(View view) {
        if (calc.checkForZero(displayData.getText().toString())){
            displayData.setText("");
        }        
        this.displayData.append(getString(R.string.num9));
        calc.setVariable(displayData.getText().toString());
    }
    public void onBtnBkspcClick(View view) {
        textas = calc.eraseLastChar(displayData.getText().toString());
        displayData.setText(textas);

    }
    public void onBtnChangeSign(View view) {
        displayData.setText(calc.changeSign(displayData.getText().toString()));
        //calc.setVariable(displayData.getText().toString());
    }
    public void onBtnSum(View view) {
        if (!calc.divisionByZeroOnEqual()){
            getDisplayDataAll.setText( calc.setOperation(getString(R.string.plus)) );
            displayData.setText("");
        }else{
            message.setText(R.string.zero);
            message.show();
        }
    }
    public void onMinusClick(View view){
        if (!calc.divisionByZeroOnEqual()){
            getDisplayDataAll.setText( calc.setOperation(getString(R.string.minus)) );
            displayData.setText("");
        }else{
            message.setText(R.string.zero);
            message.show();
        }


    }
    public void onMultiplyClick(View view){
        if (!calc.divisionByZeroOnEqual()){
            getDisplayDataAll.setText( calc.setOperation(getString(R.string.multiply)));
            displayData.setText("");
        }else{
            message.setText(R.string.zero);
            message.show();
        }

    }
    public void onDivisionClick(View view){
        if (!calc.divisionByZeroOnEqual()){
            getDisplayDataAll.setText( calc.setOperation(getString(R.string.div)));
            displayData.setText("");
        }else{
            message.setText(R.string.zero);
            message.show();
        }

    }

    public void onEqualClick(View view){
        if (calc.canUseEquual()) {
            //calc.setVariable(displayData.getText().toString());
            calc.compleatOperation();
            displayData.setText(calc.gettVariable());
            getDisplayDataAll.setText("");
        } else{
            message.setText(R.string.cantUseEqual);
            message.show();
        }
    }
    public void onSqrtClick(View view){
        String input = displayData.getText().toString();
        if (calc.checkIfPositiveNumber()){
            displayData.setText(calc.getSqrt());
        }else{
            message.setText(R.string.positive);
            message.show();
        }


    }
    public void onSqClick(View view){
        displayData.setText(calc.getSq());
    }
    public void onOverXClick(View view){
        if (!calc.checkForZero(displayData.getText().toString())){
            calc.oneOverX();
            displayData.setText(calc.gettVariable());
        } else{
            message.setText(R.string.zero);
            message.show();
        }

    }
    public void onBtnDotClick(View view){
        if (!calc.checkIfDotExist(this.displayData.getText().toString())){
            this.displayData.append(getString(R.string.point));
            calc.validNumber(this.displayData.getText().toString());
        } else{
            message.setText(R.string.pointError);
            message.show();
        }

    }
}