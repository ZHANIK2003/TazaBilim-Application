package com.example.tazabilim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ToolsActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2;
    TextView tvResult;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnSquare, btnSqrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnSquare = findViewById(R.id.btnSquare);
        btnSqrt = findViewById(R.id.btnSqrt);

        btnAdd.setOnClickListener(view -> calculate('+'));
        btnSubtract.setOnClickListener(view -> calculate('-'));
        btnMultiply.setOnClickListener(view -> calculate('*'));
        btnDivide.setOnClickListener(view -> calculate('/'));
        btnSquare.setOnClickListener(view -> calculate('^'));
        btnSqrt.setOnClickListener(view -> calculate('√'));
    }

    private void calculate(char operation) {
        double num1 = Double.parseDouble(etNumber1.getText().toString());
        double num2 = !etNumber2.getText().toString().isEmpty() ? Double.parseDouble(etNumber2.getText().toString()) : 0;
        double result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) result = num1 / num2;
                else {
                    tvResult.setText("Division by zero");
                    return;
                }
                break;
            case '^':
                result = num1 * num1;
                break;
            case '√':
                if (num1 >= 0) result = Math.sqrt(num1);
                else {
                    tvResult.setText("Negative number for sqrt");
                    return;
                }
                break;
            default:
                tvResult.setText("Invalid operation");
                return;
        }
        tvResult.setText(String.valueOf(result));
    }
}