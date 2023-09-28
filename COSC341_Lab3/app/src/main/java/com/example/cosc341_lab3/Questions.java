package com.example.cosc341_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Questions extends AppCompatActivity implements View.OnClickListener {

    //Load images from drawable
    int[] myImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

    TextView question;
    Button btnA, btnB, btnC, btnD, nextBtn;
    RadioGroup ansGroup;
    ImageView image;

    int score = 1;
    int currentQuestion = 0;
    String ans = "";
    int spinnerChoice; // number of MAX questions
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Get spinner choice from previous activity
        bundle = getIntent().getExtras();
        spinnerChoice = bundle.getInt("spinData");

        //Initialize button variables
        ansGroup = findViewById(R.id.ansGroup);
        image = findViewById(R.id.image);
        question = findViewById(R.id.question);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        nextBtn = findViewById(R.id.nextBtn);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

           loadQuestion(); // Load first question

    }

    @Override
    public void onClick(View v) {
        Button clicked = (Button) v;

            if (clicked.getId() == R.id.nextBtn) { //If "Next" button is clicked
                if (ans.equals(Questions_Answers.rightAnswers[currentQuestion])) { // If the chosen radio button contains the same string as the given answer
                    score++; //Increment score
                }
                if (currentQuestion > spinnerChoice) { //Once there are no more questions
                    nextBtn.setText("Finish");
                    nextBtn.setOnClickListener(view -> openFinalScore()); //Set "Next" button to "Finish" and on click, run shown method.
                }

                currentQuestion++; // Increment to go towards next question
                loadQuestion(); // Load next question
            } else {
                ans = clicked.getText().toString(); //If radio button is pressed, input that as the new answer
            }
    }

    void loadQuestion(){ //Loads question screen

        ansGroup.clearCheck(); //Clear radio buttons
        //Set all screen view to appropriate question. Match image with choices
        image.setImageResource(myImages[currentQuestion]);
        question.setText(Questions_Answers.question[currentQuestion]);
        btnA.setText(Questions_Answers.choices[currentQuestion][0]);
        btnB.setText(Questions_Answers.choices[currentQuestion][1]);
        btnC.setText(Questions_Answers.choices[currentQuestion][2]);
        btnD.setText(Questions_Answers.choices[currentQuestion][3]);

    }

     private void openFinalScore() { //Method to open final activity, and show final score
         Intent intent = new Intent(this, FinalScore.class);
         Bundle bundle1 = new Bundle();
         Bundle bundle2 = new Bundle();
         bundle1.putInt("spinData", spinnerChoice);
         bundle2.putInt("finalScore", score);
         intent.putExtras(bundle1);
         intent.putExtras(bundle2);
         startActivity(intent);
    }

}