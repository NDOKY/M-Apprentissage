package com.example.m_apprentissage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VideoViewActivity extends AppCompatActivity {
    //private DatabaseReference mDatabase;
    //String titreCours;
    String videoRecuperer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        videoRecuperer = getIntent().getStringExtra("VIDEO");

        WebView webView = findViewById(R.id.webViewVideo);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(videoRecuperer,"text/html",null);
    }
}