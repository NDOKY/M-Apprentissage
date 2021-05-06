package com.example.m_apprentissage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VideoViewActivity extends AppCompatActivity {
    //private DatabaseReference mDatabase;
    //String titreCours;
    String videoRecuperer;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        videoRecuperer = getIntent().getStringExtra("VIDEO");
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        WebView webView = findViewById(R.id.webViewVideo);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(videoRecuperer,"text/html",null);
    }

    public void configureNavigationView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.accueil:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.formations:
                    startActivity(new Intent(getApplicationContext(), ListeVideoActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                /*case R.id.reglages:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    return true;*/
            }
            return false;
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(item -> {
            switch (item.getItemId()){
                case R.id.accueil:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    break;
                case R.id.formations:
                    startActivity(new Intent(getApplicationContext(), ListeVideoActivity.class));
                    overridePendingTransition(0,0);
                    break;
                /*case R.id.reglages:
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    overridePendingTransition(0,0);
                    return true;*/
            }
        });
    }
}