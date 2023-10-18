package com.example.temperatureconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView display_celcius;
    TextView display_farhenheit;
    ImageView swap;
    TextView txtOutput;

    Button btnClear;

    Button btn_convert;
    EditText et_input;

    double output;
//    String message = "We have not applied logic yet.For your inconvenience we are sorry! ";

    double input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        display_celcius = findViewById(R.id.txt_celcius);
        display_farhenheit = findViewById(R.id.txt_farhenheit);
        btn_convert = findViewById(R.id.btn_convert);
        et_input = findViewById(R.id.et_userinput);
        swap = findViewById(R.id.btn_swap);
        btnClear = findViewById(R.id.btn_clear);
        txtOutput = findViewById(R.id.txt_output);
        swap.setOnClickListener(view -> swap());
        btn_convert.setOnClickListener(view -> convert());
        btnClear.setOnClickListener(view -> clear());
    }

    private void clear() {
        if (et_input.getText().toString().equals("") && txtOutput.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Already Cleared,there is nothing to clear", Toast.LENGTH_SHORT).show();
        } else {
            txtOutput.setText("");
            et_input.setText("");
        }
    }

    void swap() {
        try {
            if (display_farhenheit.getText().toString().equals("℉") && display_celcius.getText().toString().equals("℃")) {
                display_farhenheit.setText("℃");
                display_celcius.setText("℉");
                Toast.makeText(getApplicationContext(), "degree swapped", Toast.LENGTH_SHORT).show();
            } else {
                display_celcius.setText("℃");
                display_farhenheit.setText("℉");
                Toast.makeText(getApplicationContext(), "degree swapped", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Failed due to " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    void convert() {
        if (et_input.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter your value",
                    Toast.LENGTH_SHORT).show();
            et_input.setError("Please enter your value");
        } else {
            input = Double.parseDouble(et_input.getText().toString());
            if (display_farhenheit.getText().toString().equals("℉") && display_celcius.getText().toString().equals(
                    "℃")) {
                output = input * (9 / 5d) + 32;
                txtOutput.setText(String.valueOf(output));
            } else {
                output = (input - 32) * (5 / 9d);
                txtOutput.setText(String.valueOf(output));
            }
        }
    }
}