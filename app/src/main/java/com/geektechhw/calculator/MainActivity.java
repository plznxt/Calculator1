package com.geektechhw.calculator;

import static com.geektechhw.calculator.R.id.textView;
import static com.geektechhw.calculator.R.id.three;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, num1, num2, num3, num4;
    private boolean isOperationClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById (R.id.textView);
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.zero:
                setNumber("0");
                break;
            case R.id.one:
                setNumber("1");
                break;
            case R.id.two:
                setNumber("2");
                break;
            case R.id.three:
                setNumber("3");
                break;
            case R.id.four:
                setNumber("4");
                break;
            case R.id.five:
                setNumber("5");
                break;
            case R.id.six:
                setNumber("6");
                break;
            case R.id.seven:
                setNumber("7");
                break;
            case R.id.eight:
                setNumber("8");
                break;
            case R.id.nine:
              setNumber("9");
                break;
            case R.id.clear_text:
                textView.setText("0");
                first = 0;
                second = 0;
            break;
        }
    }

    private void setNumber(String number){
        if (textView.getText().toString().equals("0")){
            textView.setText(number);
        } else if (isOperationClick) {
            textView.setText(number);}
        else {textView.append(number);}
        isOperationClick = false;
    }

    @SuppressLint("NonConstantResourceId")
    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.plus:
                first = Integer.parseInt(textView.getText().toString());
                isOperationClick= true;
                break;
            case R.id.equal:
                second = Integer.parseInt(textView.getText().toString());
                Integer result = first + second;
                textView.setText(result.toString());
                isOperationClick= true;
                break;
        }
    }
}