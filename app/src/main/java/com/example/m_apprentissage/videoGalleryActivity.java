package com.example.m_apprentissage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class videoGalleryActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videogallery);
        final ListView list = findViewById(R.id.list);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("JAVA");
        arrayList.add("PHP");
        arrayList.add("CSharp");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener((parent, view, position, id) -> {
            String clickedItem = (String) list.getItemAtPosition(position);
            Intent listeVideoIntent = new Intent(getApplicationContext(), ListeVideoActivity.class);
            listeVideoIntent.putExtra("COURS",clickedItem);
            startActivity(listeVideoIntent);
        });
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

