package com.example.calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private EditText inputFirstNumber, inputSecondNumber;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);
    }
    private int firstNumber() {
        return Integer.parseInt(inputFirstNumber.getText().toString());
    }

    private int secondNumber() {
        return Integer.parseInt(inputSecondNumber.getText().toString());
    }
    public void AddNumbers(View view) {
        int result = firstNumber() + secondNumber();
        textResult.setText(String.valueOf(result));
    }

    public void SubtractNumbers(View view) {
        int result = firstNumber() - secondNumber();
        textResult.setText(String.valueOf(result));
    }

    public void MultiplyNumbers(View view) {
        int result = firstNumber() * secondNumber();
        textResult.setText(String.valueOf(result));
    }

    public void DivideNumbers(View view) {
        int num1 = firstNumber();
        int num2 = secondNumber();
        if (num2 == 0) {
            return;
        }
        int result = num1 / num2; // 整数除法，直接取整
        textResult.setText(String.valueOf(result));
    }
}