package com.example.lab2_q2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class webActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("https://www.google.ca/");
    }
}