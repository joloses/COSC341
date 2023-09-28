package com.example.lab1_q2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] choices;
    Spinner apple, banana, pear, orange;
    Button button;
    TextView total;
    double a, b, p, o;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         apple = (Spinner) findViewById(R.id.appleSpinner);
         banana = (Spinner) findViewById(R.id.banSpinner);
         pear = (Spinner) findViewById(R.id.pearSpinner);
         orange = (Spinner) findViewById(R.id.orangeSpinner);
         button = findViewById(R.id.confirmButton);
         total = findViewById(R.id.price);

        choices = new String[]{"0", "1", "2", "5", "10", "20"};
        ArrayAdapter<CharSequence> choiceAdapter= ArrayAdapter.createFromResource( this, R.array.choices, android.R.layout.simple_spinner_item);
        choiceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        apple.setAdapter(choiceAdapter);
        banana.setAdapter(choiceAdapter);
        pear.setAdapter(choiceAdapter);
        orange.setAdapter(choiceAdapter);

    }

    public void confirmBtn (View v) {
        a = Double.parseDouble((String) apple.getSelectedItem());
        b = Double.parseDouble((String) banana.getSelectedItem());
        p = Double.parseDouble((String) pear.getSelectedItem());
        o = Double.parseDouble((String) orange.getSelectedItem());

        double totalPrice = (a * 2) + (b * 2.5) + (p * 2.25) + (o * 1.80);
        total.setText("Price: $" + totalPrice);
    }


}