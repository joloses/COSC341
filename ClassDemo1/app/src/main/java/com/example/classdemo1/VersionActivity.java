package com.example.classdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VersionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);

        // Get the intent that started this activity
        Intent intent = getIntent();
        // extract the intent value in int
        int v = intent.getIntExtra("version", 0);
        SetVersion(v);

    }

    void SetVersion(int v){
        TextView label = findViewById(R.id.version_txt);
        ImageView image_view = findViewById(R.id.imageView);

        // set version code and image
        switch(v){
            case 6:
                label.setText(R.string.v6);
                image_view.setImageResource(R.drawable.marshmallow);
                break;
            case 7:
                label.setText(R.string.v7);
                image_view.setImageResource(R.drawable.nougat);
                break;
            case 8:
                label.setText(R.string.v8);
                image_view.setImageResource(R.drawable.oreo);
                break;
        }

    }


}