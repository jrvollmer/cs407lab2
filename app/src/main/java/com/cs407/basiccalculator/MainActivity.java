package com.cs407.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int[] getNumbers() {
        EditText intInput = (EditText) findViewById(R.id.intInput);
        EditText intInput2 = (EditText) findViewById(R.id.intInput2);

        int num1 = Integer.parseInt(intInput.getText().toString());
        int num2 = Integer.parseInt(intInput2.getText().toString());

        return new int[] {num1, num2};
    }

    public void add(View view) {
        // Get numbers from EditTexts
        int[] inputNums = getNumbers();

        openResultActivity(inputNums[0] + inputNums[1]);
    }

    public void subtract(View view) {
        // Get numbers from EditTexts
        int[] inputNums = getNumbers();

        openResultActivity(inputNums[0] - inputNums[1]);
    }

    public void multiply(View view) {
        // Get numbers from EditTexts
        int[] inputNums = getNumbers();

        openResultActivity(inputNums[0] * inputNums[1]);
    }

    public void divide(View view) {
        // Get numbers from EditTexts
        int[] inputNums = getNumbers();

        // If second operand is 0, show a toast to notify the user of the divide by 0 error
        if(inputNums[1] == 0) {
            Toast.makeText(MainActivity.this, "Cannot divide by 0", Toast.LENGTH_LONG).show();
        } else {
            openResultActivity((double)inputNums[0] / inputNums[1]);
        }
    }

    public void openResultActivity(double result) {
        Intent intent = new Intent(this, ResultActivity.class);

        intent.putExtra("result", result);
        startActivity(intent);
    }
}