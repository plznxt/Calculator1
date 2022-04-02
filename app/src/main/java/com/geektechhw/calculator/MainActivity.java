package com.geektechhw.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculater.R;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double first, second;
    private boolean isOperationClick;
    private String operation;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById (R.id.textView);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String result = textView.getText().toString();
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
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
                first = 0.0;
                second = 0.0;
            break;
            case R.id.tochka:
            setNumber(".");
            break;
        }
        next.setVisibility(View.INVISIBLE);
    }

    private void setNumber(String number){
        if (textView.getText().toString().equals("0")){
            textView.setText(number);
        } else if (isOperationClick) {
            textView.setText(number);}
        else {textView.append(number);}
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        next.setVisibility(View.INVISIBLE);
        switch (view.getId()){
            case R.id.percent:
                setFirst();
                isOperationClick = true;
                operation = "%";
                break;
            case R.id.plus:
                setFirst();
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.minus:
                setFirst();
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.multiplication:
                setFirst();
                isOperationClick = true;
                operation = "X";
                break;
            case R.id.division:
                setFirst();
                isOperationClick = true;
                operation = "/";
                break;
            case R.id.equal:
                setSecond();
                Double result = 0.0;
                next.setVisibility(View.VISIBLE);
                switch (operation){
                    case "%":
                        result = (first / 100.0f);
                        textView.setText(result.toString());
                        break;
                    case "+":
                        result = first + second;
                        textView.setText(result.toString());
                        break;
                    case "-":
                        result = first - second;
                        textView.setText(result.toString());
                        break;
                    case "X":
                        result = first * second;
                        textView.setText(result.toString());
                        break;
                    case "/":
                        result = first / second;
                        textView.setText(result.toString());
                        break;
                }
                break;
        }
    }

    public void setFirst () {
        first = Double.parseDouble(textView.getText().toString());
    }
    public void setSecond () {
        second = Double.parseDouble(textView.getText().toString());
    }
}