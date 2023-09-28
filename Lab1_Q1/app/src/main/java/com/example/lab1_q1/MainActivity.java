package com.example.lab1_q1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int num = 0;
    int[] myImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    TextView count;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         count = findViewById(R.id.counter);
         image = findViewById(R.id.imageView);

    }
            public void next (View v) {
                num++;
                if (num > 3) {
                    num = 0;
                }
                image.setImageResource(myImages[num]);
                count.setText((num + 1) + " of 4");
            }

        public void prev (View v){
            num--;
            if (num < 0) {
                num = 3;
            }
            image.setImageResource(myImages[num]);
            count.setText((num + 1) + " of 4");
        }

            public void random (View v) {
                num = (int) (Math.random() * 4);
                count.setText((num + 1) + " of 4");
                image.setImageResource(myImages[num]);

            }

}
