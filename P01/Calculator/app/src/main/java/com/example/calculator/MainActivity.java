package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNumber = findViewById(R.id.firstNumber);
        EditText secondNumber = findViewById(R.id.secondNumber);
        Button addButton = findViewById(R.id.addButton);
        TextView result = findViewById(R.id.resultView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(firstNumber.getText().toString());
                int j = Integer.parseInt(secondNumber.getText().toString());
                int sum = i+j;
                result.setText(String.valueOf(sum));
            }
        });
    }
}