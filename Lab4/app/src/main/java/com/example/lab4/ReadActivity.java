package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadActivity extends AppCompatActivity {

    TextView txtOutput;
    int counter = 0;
    Button prevBtn, nextBtn, mainBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        txtOutput = findViewById(R.id.txtOutput);

        mainBtn = findViewById(R.id.mainBtn);
        mainBtn.setOnClickListener(view -> onMainClick());

        String file = "output.txt";
        String line = "";
        String data = "";

        //File read operation
        try {
            FileInputStream fis = openFileInput(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                data += (counter+1) + "\t"+ line +"\n";
                counter++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //Show the data
        txtOutput.setText(data);
    }

    public void onMainClick(){
        finish();
    }
}

