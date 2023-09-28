package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class WriteActivity extends AppCompatActivity {

    EditText lastName, firstName, stuNum;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        firstName = findViewById(R.id.editFirst);
        lastName = findViewById(R.id.editLast);
        stuNum = findViewById(R.id.editStuNum);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(view -> onWriteSubmit());
    }


    public void onWriteSubmit(){

        if (firstName.getText().toString().length() < 1) {
            Toast.makeText(this, "Invalid First Name!", Toast.LENGTH_LONG).show();
            return;
        }
        if (lastName.getText().toString().length() < 1) {
            Toast.makeText(this, "Invalid Last Name!", Toast.LENGTH_LONG).show();
            return;
        }

        if (stuNum.getText().toString().length() != 8) {
            Toast.makeText(this, "Invalid Student Number! Must be 8 Digits", Toast.LENGTH_LONG).show();
            return;
        }

        //File write operation
        String filename = "output.txt";
        String fileContents = firstName.getText().toString() + "\n" + lastName.getText().toString() + "\n" + stuNum.getText().toString() + "\n";
        FileOutputStream outputStream;  //Allow a file to be opened for writing

        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        finish();

    }
}

