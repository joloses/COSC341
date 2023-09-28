package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button readBtn, writeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readBtn = findViewById(R.id.readBtn);
        writeBtn = findViewById(R.id.writeBtn);

        readBtn.setOnClickListener(view -> onReadData());
        writeBtn.setOnClickListener(view -> onWriteData());
    }

    //Click on read button: open new activity called ReadActivity
    public void onReadData(){
        Intent intent = new Intent(this, ReadActivity.class);
        startActivity(intent);
    }


    //Click on write button: open new activity called WriteActivity
    public void onWriteData(){
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }
}