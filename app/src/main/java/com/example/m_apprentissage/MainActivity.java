package com.example.m_apprentissage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*String http = "<iframe src=\"https://yvesndoky.h5p.com/content/1291302058534816898/embed\" width=\"1088\" height=\"637\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\" allow=\"geolocation *; microphone *; camera *; midi *; encrypted-media *\"></iframe><script src=\"https://yvesndoky.h5p.com/js/h5p-resizer.js\" charset=\"UTF-8\"></script>";

        setContentView(R.layout.videoframe);
        WebView webView = (WebView)findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(http, "text/html",null);*/
    }
}