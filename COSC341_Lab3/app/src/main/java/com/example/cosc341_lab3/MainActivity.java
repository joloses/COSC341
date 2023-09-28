package com.example.cosc341_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Spinner qSpin;
    Button loadQuiz;
    int spinnerSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Load spinner and input choices in spinner.
        qSpin = (Spinner) findViewById(R.id.qSpinner);
        Integer[] choices = new Integer[]{1,2,3,4};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, choices);
        qSpin.setAdapter(adapter);
        spinnerSelect = (int) qSpin.getSelectedItem();

        //Run openQuestionActivity() method when "Load Quiz" button is pressed
        loadQuiz = findViewById(R.id.loadButton);
        loadQuiz.setOnClickListener(view -> openQuestionActivity());

    }

    private void openQuestionActivity() { //New activity to load questions, take spinner selection to input amount of questions
        Intent intent = new Intent(this, Questions.class);
        Bundle bundle = new Bundle();
        bundle.putInt("spinData", spinnerSelect);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
