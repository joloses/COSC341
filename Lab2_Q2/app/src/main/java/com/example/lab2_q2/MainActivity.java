package com.example.lab2_q2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void webButton(View v) {
        Intent webActivity = new Intent(this, webActivity.class);
        startActivity(webActivity);
    }

    public void mapButton(View v) {
        Intent mapActivity = new Intent(this, MapsActivity.class);
        startActivity(mapActivity);
    }


}