package com.example.lab2_q1_act1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName, lastName, studentNumber;
    String gender, division;
    CheckBox checkbox;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        studentNumber = findViewById(R.id.studNum);
        division = (String) spinner.getSelectedItem();

        Context context = getApplicationContext();
        if (studentNumber.length() < 8) {
            Toast numToast = Toast.makeText(context, "Student number must be 8 digits!", Toast.LENGTH_LONG);
        }
        else if (lastName.length() < 0 | firstName.length() < 0) {
            Toast numToast = Toast.makeText(context, "Enter a valid name.", Toast.LENGTH_LONG);
        }
        else if (checkbox.isChecked() == false) {
            Toast numToast = Toast.makeText(context, "Robot detected!", Toast.LENGTH_LONG);
        }

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getFirstName = firstName.getText().toString();
                String getLastName = lastName.getText().toString();
                String getNumber = studentNumber.getText().toString();
                String getDivision = division.toString();
                String getGender = gender.toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("firstName", getFirstName);
                intent.putExtra("lastName" , getLastName);
                intent.putExtra("number", getNumber);
                intent.putExtra("gender", getGender);
                intent.putExtra("division", getDivision);
                startActivity(intent);
            }
        });

    }

    public void onRadioButtonClicked(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.maleBtn:
                if (checked) {
                    gender = "Male";
                    break;
                }
            case R.id.femaleBtn:
                if (checked) {
                    gender = "Female";
                    break;
                }
        }
    }



}