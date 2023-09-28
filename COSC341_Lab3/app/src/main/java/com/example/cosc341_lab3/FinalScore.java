package com.example.cosc341_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FinalScore extends AppCompatActivity {

    TextView score;
    Button done;
    int spinnerChoice;
    int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        //Append data from previous activity
        Bundle data = getIntent().getExtras();
        finalScore = (data.getInt("finalScore"));

        Bundle bundle = getIntent().getExtras();
        spinnerChoice = bundle.getInt("spinData");

        //Set score to match the user's score
        score = findViewById(R.id.score);
        score.setText((finalScore) + "/" + 4); // ***Change 4 to spinnerChoice

        //When "Done" button is pressed, run method below
        done = findViewById(R.id.doneBtn);
        done.setOnClickListener(view -> openMainActivity());
    }

    private void openMainActivity() { //Method to go back to start menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}