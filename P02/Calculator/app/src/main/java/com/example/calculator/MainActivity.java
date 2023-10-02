package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.DisplayMetrics;
import android.widget.TextView;
import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNumber = findViewById(R.id.firstNumber);
        EditText secondNumber = findViewById(R.id.secondNumber);
        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);
        Button divideButton = findViewById(R.id.divideButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
//        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout2);


        TextView result = findViewById(R.id.resultView);

//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        int width = displayMetrics.widthPixels;
//
//        constraintLayout.setMinHeight(width/10);


            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        double i = Double.parseDouble(firstNumber.getText().toString());
                        double j = Double.parseDouble(secondNumber.getText().toString());
                        double sum = i + j;
                        result.setText(String.valueOf(sum));
                    }
                    catch(NumberFormatException e)
                    {
                        result.setText("Cannot enter a string, must be numbers.");
                    }
                }
            });

            subtractButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        double i = Double.parseDouble(firstNumber.getText().toString());
                        double j = Double.parseDouble(secondNumber.getText().toString());
                        double sum = i - j;
                        result.setText(String.valueOf(sum));
                    }
                    catch(NumberFormatException e)
                    {
                        result.setText("Cannot enter a string, must be numbers.");
                    }
                }
            });

            multiplyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        double i = Double.parseDouble(firstNumber.getText().toString());
                        double j = Double.parseDouble(secondNumber.getText().toString());
                        double sum = i * j;
                        result.setText(String.valueOf(sum));
                    }
                    catch(NumberFormatException e)
                    {
                        result.setText("Cannot enter a string, must be numbers.");
                    }
                }
            });

            divideButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        double i = Double.parseDouble(firstNumber.getText().toString());
                        double j = Double.parseDouble(secondNumber.getText().toString());
                        double sum = i / j;
                        result.setText(String.valueOf(sum));
                    } catch (ArithmeticException e) {
                        result.setText("You cannot divide by 0.");
                    }
                    catch (NumberFormatException e)
                    {
                        result.setText("You must enter numbers not letters.");
                    }
                }
            });
    }
}