package com.example.lab2_q1_act1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    TextView name2, number2, division2, gender2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name2 = findViewById(R.id.name2);
        number2 = findViewById(R.id.number2);
        division2 = findViewById(R.id.division2);
        gender2 = findViewById(R.id.gender2);

        Intent intent = getIntent();
        String getFirstName = intent.getStringExtra("firstName");
        String getLastName = intent.getStringExtra("lastName");
        String getNumber = intent.getStringExtra("number");
        String getDivision = intent.getStringExtra("division");
        String getGender = intent.getStringExtra("gender");
        String fullName = getFirstName + " " + getLastName;

        name2.setText(fullName);
        number2.setText(getNumber);
        gender2.setText(getGender);
        division2.setText(getDivision);


    }
}