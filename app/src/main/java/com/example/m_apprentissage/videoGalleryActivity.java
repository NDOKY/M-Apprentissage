package com.example.m_apprentissage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class videoGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videogallery);
        final ListView list = findViewById(R.id.list);

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
}

